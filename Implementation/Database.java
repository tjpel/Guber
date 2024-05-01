package main;

import java.util.ArrayList;
//do IO shit here with a TXT?

public class Database {
	
	private static Database instance;
	private ArrayList<User> userList;
	private ArrayList<Operator> opList;
	int nextUserID;
	
	private Database() {
		userList = new ArrayList<User>();
		opList = new ArrayList<Operator>();
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
	public ArrayList<Operator> getOperators() { 
		System.out.println("LOG: Database - fetching all Operators from Database."); 
		return opList; 
	}

	public void createAccount(User u) {
		System.out.println("LOG: Created new User Account in Database.");
		userList.add(u);
	}
	
	public void addOperator(Operator o) {
		opList.add(o);
	}
	
	public boolean checkAccount(User u) {
		System.out.println("LOG: Database checking that account exists and is in good standing."); 
		return userList.contains(u) && u.inGoodStanding;
	}
	     
}
