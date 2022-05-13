package de.bredex.account.application.api;

public class AccountDto {

    private String firstName;
    private String lastName;

    public AccountDto(String firstName, String lastName) {
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