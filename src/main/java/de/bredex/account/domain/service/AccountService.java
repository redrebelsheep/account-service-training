package de.bredex.account.domain.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bredex.account.domain.model.Account;
import de.bredex.account.domain.spi.AccountDao;
import de.bredex.account.domain.spi.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAccounts() {
	List<Account> accounts = new LinkedList<>();
	
	repository.findAll().forEach( account -> accounts.add(new Account(account.getId(), account.getFirstName(), account.getLastName())));
	
	return accounts;
    }

    public Account createAccount(Account account) {
	AccountDao savedAccount = repository.save(new AccountDao(account.getFirstName(), account.getLastName()));
	return new Account(savedAccount.getId(), savedAccount.getFirstName(), savedAccount.getLastName());
    }
}
