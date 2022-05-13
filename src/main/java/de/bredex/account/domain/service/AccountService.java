package de.bredex.account.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import de.bredex.account.domain.model.Account;
import de.bredex.account.domain.spi.AccountDao;
import de.bredex.account.domain.spi.AccountRepository;

@Service
public class AccountService {

    private AccountRepository repository;
    
    public AccountService(AccountRepository repository) {
	this.repository = repository;
    }

    public List<Account> getAccounts() {
	List<Account> accounts = new LinkedList<>();
	
	repository.findAll().forEach( account -> accounts.add(new Account(account.getFirstName(), account.getLastName())));
	
	return accounts;
    }

    public Account createAccount(Account account) {
	AccountDao savedAccount = repository.save(new AccountDao(account.getFirstName(), account.getLastName()));
	return new Account(savedAccount.getFirstName(), savedAccount.getLastName());
    }
}
