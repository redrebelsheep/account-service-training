package de.bredex.account.application.api;

public class AccountRequest {

    private final String firstName;
    private final String lastName;

    public AccountRequest(final String firstName, final String lastName) {
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    public String getFirstName() {
	return firstName;
    }
    
    public String getLastName() {
	return lastName;
    }
}
