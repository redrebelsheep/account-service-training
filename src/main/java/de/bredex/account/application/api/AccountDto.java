package de.bredex.account.application.api;

public class AccountDto {

    private String number;
    private String firstName;
    private String lastName;
    
    public AccountDto() {
    }

    public AccountDto(String number, String firstName, String lastName) {
	this.number = number;
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    public AccountDto(String firstName, String lastName) {
	this.number = null;
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
