package main;

import java.util.ArrayList;

public class User extends Person{
	
	ArrayList<String> savedLocations;
	double accountBalance;
	int userId;
	ArrayList<Card> paymentMethods;
	
	public User(String name, String dob, String emailAddress, String cellPhone, String address) {
		
		super(name, dob, emailAddress, cellPhone, address);
		
		savedLocations = new ArrayList<String>();
		accountBalance = 0.0;
		userId = Database.getInstance().getNextUserID();
		paymentMethods = new ArrayList<Card>();
		
	}

}
