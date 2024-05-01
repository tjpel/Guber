package main;

import java.util.ArrayList;

public class User extends Person{
	
	ArrayList<String> savedLocations;
	double accountBalance = 20.00; //sign-up bonus
	int userId;
	ArrayList<Card> paymentMethods;
	boolean inGoodStanding;
	
	public User(String name, String dob, String emailAddress, String cellPhone, String address) {
		
		super(name, dob, emailAddress, cellPhone, address);
		
		this.savedLocations = new ArrayList<String>();
		this.accountBalance = 0.0;
		this.userId = Database.getInstance().getNextUserID();
		this.paymentMethods = new ArrayList<Card>();
		this.inGoodStanding = true;
		
		System.out.printf("LOG: Created new User %s. \n", name);
		
	}
	
	public void deductFee(double fee) {
		accountBalance -= fee;
	}

}
