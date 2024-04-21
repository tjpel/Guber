package main;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Set up infastructure
		Admin a1 = new Admin(1, "", "", "", "", "");
		Server usServer = new Server(a1);
		
		User u1 = new User("Billy", "", "", "", "");
		
		AppController ap = new AppController(usServer); //Billy launches app, which connects to server
		
		System.out.println("LOG: Calling AppController's createApprovalMessage from Main.");
		ap.createAccount(u1); //Billy tries to create account
	}

}
