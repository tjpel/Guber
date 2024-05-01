package main;

import java.util.*;

public class Server {
	
	private Admin serverAdmin;
	private Database db;

	
	public Server(Admin a) {
		this.serverAdmin = a;
		db = Database.getInstance();
		System.out.println("LOG: Created new Server.");
	}
	
	public boolean evaluateAccountDetails(User u) {
		//ensure User's info is in correct format
		boolean correct = true;
		
		if(correct) {
			System.out.println("LOG: Calling Admin's sendAccountForApproval from Server.");
			return serverAdmin.sendAccountForApproval(u); //choice goes to admin
		}else {
			System.out.println("LOG: Create Account Application Denied.");
			return false;
		}
	}
	
	public boolean handleLogin(User u) {
		System.out.println("LOG: Calling Databases's checkAccount from Server."); 
		return db.checkAccount(u);
	}
	
	public Operator findOperators(HashMap<String, String> pref, User u) {
		System.out.println("LOG: Calling Database's getOperators from Server."); 
		ArrayList<Operator> opList = db.getOperators();
		
		System.out.println("LOG: Server - Attempting to match an Operator to Rider's preferences."); 
		for(Operator op : opList) {
			/*
			 * check if all pref matches any operator
			 * set this up weird for scalability, just add more if statements that 
			 * turn off opMatchesAll if it doesn't match
			 */
			
			boolean opMatchesAll = true;
			if(op.comedyType != pref.getOrDefault("Comedy", null)) {
				opMatchesAll = false;
			}
			
			if(opMatchesAll) {
				if(op.notifyOperator(u)) { //notify operator, return them if they accept
					System.out.println("LOG: Server - Found a matching Operator!"); 
					return op; //assuming acceptance for demo
				}
			}
		}
		
		System.out.println("LOG: Server - No matching Operators found."); 
		return null;
	}
	
	public double findDistance(Person a, Person b) {
		return DistanceFinder.findDistance(a, b);
	}
	
	public void detectRideCompleted(User u, Operator o) {
		System.out.println("LOG: Calling Operator's compensateOperator from Server."); 
		o.compensateOperator(10.00); //stub number
		System.out.println("LOG: Calling User's deductFee from Server."); 
		u.deductFee(12.00);//stub number
		//we profit $2.00!!
		
	}
}
