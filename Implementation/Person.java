package main;

public abstract class Person {
	
	String name; //ex. First MI Last
	String dob; //MM-DD-YYYY
	String emailAddress; //xx@yy.zz
	String cellPhone; //(000)000-000
	String address; //XXXX Street, Apt YYY, City, State ZIP
	
	public Person() {}
	
	public Person(String name, String dob, String emailAddress, String cellPhone, String address) {
		this.name = name;
		this.dob = dob;
		this.emailAddress = emailAddress;
		this.cellPhone = cellPhone;
		this.address = address;
	}

}
