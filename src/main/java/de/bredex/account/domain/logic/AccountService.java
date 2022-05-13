package de.bredex.account.domain.logic;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.bredex.account.domain.model.Account;
import de.bredex.account.domain.spi.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public List<Account> getAccounts() {
	return repository.getAccounts().stream().map(dao -> new Account(dao.getFirstName(), dao.getLastName()))
		.collect(Collectors.toList());
    }
}
