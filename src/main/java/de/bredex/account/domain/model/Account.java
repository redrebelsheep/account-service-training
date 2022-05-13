package de.bredex.account.domain.model;

public class Account {

    private String number;
    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName) {
	this.number = null;
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    public Account(String number, String firstName, String lastName) {
	this.number = number;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public String getNumber() {
	return number;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
