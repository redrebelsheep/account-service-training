package de.bredex.account.infrastructure;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.bredex.account.domain.spi.AccountDao;
import de.bredex.account.domain.spi.AccountRepository;

@Component
public class AccountInMemoryRepository implements AccountRepository {
    
    private List<AccountDao> accounts = new LinkedList<>();
    
    @Override
    public List<AccountDao> getAccounts() {
	return Collections.unmodifiableList(accounts);
    }

    @Override
    public AccountDao saveAccount(AccountDao accountDao) {
	accounts.add(accountDao);
	return accountDao;
    }
}
