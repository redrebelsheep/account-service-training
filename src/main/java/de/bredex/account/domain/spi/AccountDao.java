package de.bredex.account.domain.spi;

public class AccountDao {

    private String firstName;
    private String lastName;

    public AccountDao(String firstName, String lastName) {
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
