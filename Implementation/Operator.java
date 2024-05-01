package main;

import java.util.ArrayList;

public class Operator extends Person{
	
	public ArrayList<Vehicle> vehicles;
	public String comedyType;
	private double storedCompensation = 0;
	
	public boolean notifyOperator(User u) {//notifies operator that a ride was found for them, in full app could return false if op denies
		//TODO: display User info here
		return true;
	}
	
	
	public Operator(String name, String dob, String emailAddress, String cellPhone, String address, String comedyType) {
		
		super(name, dob, emailAddress, cellPhone, address);
		this.comedyType = comedyType;
		
		Database.getInstance().addOperator(this);
		
		System.out.printf("LOG: Created new Operator %s. \n", name);
		
	}
	
	public void addVehicle(Vehicle v) { vehicles.add(v); }
	
	public void compensateOperator(double fee) {this.storedCompensation += fee;}
		

}
