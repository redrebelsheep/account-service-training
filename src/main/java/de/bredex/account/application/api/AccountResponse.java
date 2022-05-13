package de.bredex.account.application.api;

public class AccountResponse {

    private final String number;
    private final String firstName;
    private final String lastName;

    public AccountResponse(final String number, final String firstName, final String lastName) {
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
