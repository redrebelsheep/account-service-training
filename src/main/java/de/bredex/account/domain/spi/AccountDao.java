package de.bredex.account.domain.spi;

import java.util.UUID;

public class AccountDao {

    private UUID id;
    private String firstName;
    private String lastName;

    public AccountDao(String firstName, String lastName) {
	this.id = UUID.randomUUID();
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
