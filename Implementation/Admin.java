package main;

import java.util.ArrayList;
import java.util.Random;

public class Admin extends Person {
	
	int adminID;
	Database db;
	
	//this solution feels bad.
	//Server needs an admin to send messages to, but it feels weird to have an admin be owned by a server
	//So, we have a list of admins that are available to handle requests. Objects can grab a random one with getAdmin()
	private ArrayList<Admin> availableAdmins;
	
	public Admin(int adminID, String name, String dob, String emailAddress, String cellPhone, String address) {
		super(name, dob, emailAddress, cellPhone, address);
		db = Database.getInstance();
	}
	
	public boolean sendAccountForApproval(User u) {
		//Admin reviews information and somehow approves or denies account
		//TODO: make some reasons to approve or deny (age?)
		//returns true if account approved
		boolean approval = true;
		
		if(approval) {
			System.out.println("LOG: Calling Database's createAccount from Admin.");
			db.createAccount(u);
			System.out.println("LOG: Create Account Application Approved.");
			return true;
		}else {
			System.out.println("LOG: Create Account Application Denied.");
			return false;
		}
	}

}
