package de.bredex.account.application.api;

import java.util.UUID;

public class AccountDto {

    private UUID id;
    private String firstName;
    private String lastName;
    
    public AccountDto() {
    }

    public AccountDto(UUID id, String firstName, String lastName) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    public AccountDto(String firstName, String lastName) {
	this.id = null;
	this.firstName = firstName;
	this.lastName = lastName;
    }
   

    public UUID getId() {
	return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
