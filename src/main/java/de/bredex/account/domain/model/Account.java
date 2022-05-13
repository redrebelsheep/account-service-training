package de.bredex.account.domain.model;

import java.util.UUID;

public class Account {

    private UUID id;
    private String firstName;
    private String lastName;

    public Account(UUID id, String firstName, String lastName) {
	this.id = id;
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
