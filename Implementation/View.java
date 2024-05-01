package main;

import java.util.Scanner;

public class View {

	AppController app;
	Scanner input;
	
	public View(AppController app) {
		this.app = app;
		this.input = new Scanner(System.in);
		System.out.println("LOG: Creating 'UI' for App.");
	}
	
	//below are just sent to app, creating a barrier between client and app
	public void createAccount(User u) {
		System.out.println("LOG: Calling App's createAccount from View."); 
		app.createAccount(u); 
	}
	public void logIntoAccount(User u) { 
		System.out.println("LOG: Calling Apps's logIntoAccount from View."); 
		app.logIntoAccount(u); 
	}
	public void requestRide() throws NoLoginError, InterruptedException { 
		System.out.println("LOG: Calling Apps's requestRide from View."); 
		app.requestRide(); 
	}
	
	
	public void createApprovalMessage() {
		//Display a message that their account has been approved
		
		System.out.println("Good news! Your account has been approved and you can now request rides.");
		System.out.println("Congratulations on being the newest addition to the Guber family.");
	}
	
	public void createDenialMessage(User u) {
		System.out.println("Unfortunatly, the information provided is incorrect or does not align with our terms of service.");
		System.out.println("Your application has been denied.");
		u = null; //destroy User object (thank you garbage collector!)
	}
	
	public void displayHomeScreen() {
		System.out.println("");
		System.out.println("Welcome! Please choose an option:");
		System.out.println("1. Set Preferences");
		
		int choice = input.nextInt();
		
		switch(choice) {
			case 1:
				System.out.println("LOG: Calling View's changePreference from View."); 
				changePreference();
				break;
			default:
				System.out.println("Invalid option.");
				displayHomeScreen();
		}
	}
	
	public void informLoginProblem() {
		System.out.println("There was a problem with your login. Please try again later.");
	}
	
	public void changePreference() {
		
		String key;
		
		System.out.println("You can change your preferences in this menu.");
		System.out.println("Please choose a preference to change.");
		System.out.println("1. Set Comedy Preference");
		
		int choice = input.nextInt();
		

		switch(choice) {
			case 1:
				key = "Comedy";
				System.out.println("Okay! What shall we change it to?");
				System.out.println("1. Dark Humor");
				System.out.println("2. Political Humor");
				
				int choice2 = input.nextInt();
				
				System.out.println("LOG: Calling App's setPreference from View."); 
				switch(choice2) {
					case 1:
						app.setPreference(key, "Dark");
						break;
					case 2:
						app.setPreference(key, "Political");
						break;
					default:
						System.out.println("Invalid option.");
						changePreference();
						return;
				}
				break;
			default:
				System.out.println("Invalid option.");
				changePreference();
				return;
		}
	}
	
	public void rideCompleted() {
		System.out.println("Your ride has now been completed. Thank you for using Guber!");
	}
	
	

}
