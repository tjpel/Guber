package main;

import java.util.ArrayList;
//do IO shit here with a TXT?

public class Database {
	
	private static Database instance;
	private ArrayList<User> userList;
	int nextUserID;
	
	private Database() {
		userList = new ArrayList<User>();
		System.out.println("LOG: Database instance created.");
		nextUserID = 1;
	}
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public int getNextUserID() { return nextUserID++; } //returns the next availible userID then increments

	public void createAccount(User u) {
		System.out.println("LOG: Created new User Account in Database.");
		userList.add(u);
	}
	
}
