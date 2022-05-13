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

	repository.findAll()
		.forEach(account -> accounts.add(new Account(account.getNumber(), account.getFirstName(), account.getLastName())));

	return accounts;
    }

    public Account createAccount(Account account) {
	String accountNumber = nextAccountNumber();
	AccountDao savedAccount = repository.save(new AccountDao(accountNumber, account.getFirstName(), account.getLastName()));
	return new Account(savedAccount.getNumber(), savedAccount.getFirstName(), savedAccount.getLastName());
    }

    private String nextAccountNumber() {
	Integer nextNumber = getAccounts().stream().mapToInt(account -> Integer.valueOf(account.getNumber())).max().orElse(10000); 
	return String.format("%04d", nextNumber + 1);
    }
}
