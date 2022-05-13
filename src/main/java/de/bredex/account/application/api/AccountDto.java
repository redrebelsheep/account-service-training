package de.bredex.account.application.api;

public class AccountDto {

    private Integer id;
    private String firstName;
    private String lastName;
    
    public AccountDto() {
    }

    public AccountDto(Integer id, String firstName, String lastName) {
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
    }
    
    public AccountDto(String firstName, String lastName) {
	this.id = null;
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
