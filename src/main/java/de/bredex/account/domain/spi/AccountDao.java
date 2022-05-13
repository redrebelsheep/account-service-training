package de.bredex.account.domain.spi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class AccountDao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String number;
    private String firstName;
    private String lastName;
    
    public AccountDao() {}
    
    public AccountDao(String number, String firstName, String lastName) {
	this.number = number;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public Integer getId() {
	return id;
    }
    
    public void setId(Integer id) {
	this.id = id;
    }
    
    public String getNumber() {
	return number;
    }
    
    public String getFirstName() {
	return firstName;
    }
    
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }
    
    public String getLastName() {
	return lastName;
    }
    
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }
}
