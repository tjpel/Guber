package main;

public class View {
	
	public void createApprovalMessage() {
		//Display a message that their account has been approved
		System.out.println("Good news! Your account has been approved and you can now request rides.");
		System.out.println("Congratulations on being the newest addition to the Guber family.");
	}
	
	public void createDenialMessage(User u) {
		System.out.println("Unfortunatly, the information provided is incorrect or does not align with our terms of service.");
		System.out.println("Your application has been denied.");
		u = null; //destroy User object
	}

}
