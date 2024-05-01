package main;

public class Admin extends Person {
	
	int adminID;
	Database db;
	
	
	
	public Admin(int adminID, String name, String dob, String emailAddress, String cellPhone, String address) {
		super(name, dob, emailAddress, cellPhone, address);
		db = Database.getInstance();
		System.out.println("LOG: Created new Admin.");
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
