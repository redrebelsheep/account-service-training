package de.bredex.account.domain.model;

public class Account {

    private String firstName;
    private String lastName;

    public Account(String firstName, String lastName) {
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
