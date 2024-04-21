package main;

public class AppController {
	
	private View v;
	private Server server;
	
	public AppController(Server s) {
		v = new View();
		this.server = s;
	}
	
	public void createAccount(User u) { 
		//doing it this way as a view could have multiple users (just not at the same time)
		System.out.println("LOG: Calling Server's evaluteAccountDetails from AppController.");
		if(server.evaluateAccountDetails(u)) {
			System.out.println("LOG: Calling Views's createApprovalMessage from AppController.");
			v.createApprovalMessage();
		}else {
			System.out.println("LOG: Calling Views's createDenialMessage from AppController.");
			v.createDenialMessage(u);
		}
	}

}
