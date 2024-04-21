package main;

public class Server {
	
	private Admin serverAdmin;
	
	public Server(Admin a) {
		this.serverAdmin = a;
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

}
