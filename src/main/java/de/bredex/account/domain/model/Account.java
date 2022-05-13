package de.bredex.account.domain.model;

public class Account {

    private Integer id;
    private String firstName;
    private String lastName;

    public Account(Integer id, String firstName, String lastName) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Integer getId() {
	return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
