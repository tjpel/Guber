package main;

public class Client {

	public static void main(String[] args) throws NoLoginError, InterruptedException {
		// TODO Auto-generated method stub
		
		//Set up infrastructure
		Admin a1 = new Admin(1, "", "", "", "", "");
		Server usServer = new Server(a1);
		Operator o1 = new Operator("Calvin", "", "", "", "", "Dark");
		Operator o2 = new Operator("Emily", "", "", "", "", "Political");
		
		User u1 = new User("Billy", "", "", "", "");
		
		AppController ap = new AppController(usServer); //Billy launches app, which connects to server
		View v = ap.getView();
		
		System.out.println("LOG: Calling View's createAccount from Main.");       
		v.createAccount(u1); //Billy tries to create account
		
		System.out.println("LOG: Calling View's logIntoAccount from Main."); 
		v.logIntoAccount(u1);
		
		System.out.println("LOG: Calling View's requestRide from Main."); 
		v.requestRide();
		

		
		//v.changePreference();
	}

}
