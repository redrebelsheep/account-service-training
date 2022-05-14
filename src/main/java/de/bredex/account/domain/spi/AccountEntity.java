package de.bredex.account.domain.spi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public final class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String number;
    private String firstName;
    private String lastName;
    
    public AccountEntity() {}
    
    public AccountEntity(final String number, final String firstName, final String lastName) {
	this.number = number;
	this.firstName = firstName;
	this.lastName = lastName;
    }

    public final Integer getId() {
	return id;
    }
    
    public final void setId(final Integer id) {
	this.id = id;
    }
    
    public final String getNumber() {
	return number;
    }
    
    public final void setNumber(final String number) {
	this.number = number;
    }
    
    public final String getFirstName() {
	return firstName;
    }
    
    public final void setFirstName(final String firstName) {
	this.firstName = firstName;
    }
    
    public final String getLastName() {
	return lastName;
    }
    
    public final void setLastName(final String lastName) {
	this.lastName = lastName;
    }
}
