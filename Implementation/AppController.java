package main;

import java.util.*;

public class AppController {
	
	private View v;
	private Server server;
	private HashMap<String, String> preferences;
	private User loggedInUser;
	
	public AppController(Server s) {
		v = new View(this);
		this.server = s;
		this.preferences = new HashMap<String, String>();
		System.out.println("LOG: App Started!");
	}
	
	public View getView() { //this is only for the demo, shouldn't exist
		return v;
	}
	
	public void createAccount(User u) { 
		//doing it this way as a view could have multiple users (just not at the same time)
		System.out.println("LOG: Calling Server's evaluteAccountDetails from App.");
		if(server.evaluateAccountDetails(u)) {
			System.out.println("LOG: Calling Views's createApprovalMessage from App.");
			v.createApprovalMessage();
		}else {
			System.out.println("LOG: Calling Views's createDenialMessage from App.");
			v.createDenialMessage(u); //pass User so it can be destroyed
		}
	}
	
	public void logIntoAccount(User u) {
		System.out.println("LOG: Calling Server's handleLogin from App."); 
		if(server.handleLogin(u)) {
			loggedInUser = u;
			System.out.println("LOG: Calling View's displayHomeScreen from App."); 
			v.displayHomeScreen();
		}else {
			System.out.println("LOG: Calling View's infromLoginProblem from App."); 
			v.informLoginProblem();
		}
	}
	
	
	public void setPreference(String key, String val) {
		if(preferences.containsKey(key)) { //if we need to overwrite, first clear the value
			preferences.remove(key);
		}
		
		preferences.put(key, val);//write new preference
	}
	
	public void requestRide() throws NoLoginError, InterruptedException {
		
		if(loggedInUser == null) {
			throw new NoLoginError("A user must be logged in to request a ride.");
		}
		
		System.out.println("LOG: Calling Servers's findOperators from App."); 
		Operator match = server.findOperators(preferences, loggedInUser);
		
		if(match == null) {
			System.out.println("We could not find any operators that match your preferences at this time.");
		}
		
		System.out.printf("Found an operator who matches your preferences! Their name is: %s \n", match.name);
		System.out.println("LOG: Calling Server's findDistance from App.");
		System.out.printf("They are %f mi away. \n", server.findDistance(loggedInUser, match));
		
		//in full app, this would be called when the distance to both the user and operator to the
		//requested location is <= 0.5mi
		
		System.out.println("LOG: Rider has been picked up, Rider and Operator moving to requested location."); 
		Thread.sleep(3500);
		
		System.out.println("LOG: Ride completed. Rider and Operator's locations within 0.5mi to drop-off."); 
		System.out.println("LOG: Calling Server's detectRideCompleted from App."); 
		server.detectRideCompleted(loggedInUser, match);
		
		System.out.println("LOG: Calling View's rideCompleted from App."); 
		v.rideCompleted();
	}

}
