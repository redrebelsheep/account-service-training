package de.bredex.account.infrastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import de.bredex.account.domain.spi.AccountDao;
import de.bredex.account.domain.spi.AccountRepository;

@Component
public class AccountInMemoryRepository implements AccountRepository {

    @Override
    public List<AccountDao> getAccounts() {
	List<AccountDao> accounts = new ArrayList<>();
	
	accounts.add(new AccountDao("Timo", "Rohrberg"));
	accounts.add(new AccountDao("Max", "Mustermann"));
	accounts.add(new AccountDao("Petra", "Musterfrau"));
	
	return Collections.unmodifiableList(accounts);
    }

}
