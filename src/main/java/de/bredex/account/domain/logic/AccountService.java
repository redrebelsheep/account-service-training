package de.bredex.account.domain.logic;

import java.util.List;
import java.util.stream.Collectors;

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
	return repository.getAccounts().stream().map(dao -> new Account(dao.getId(), dao.getFirstName(), dao.getLastName()))
		.collect(Collectors.toList());
    }

    public Account createAccount(Account account) {
	AccountDao savedAccount = repository.saveAccount(new AccountDao(account.getFirstName(), account.getLastName()));
	return new Account(savedAccount.getId(), savedAccount.getFirstName(), savedAccount.getLastName());
    }
}
