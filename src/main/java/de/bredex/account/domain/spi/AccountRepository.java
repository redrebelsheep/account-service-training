package de.bredex.account.domain.spi;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository {

    public List<AccountDao> getAccounts();

    public AccountDao saveAccount(AccountDao accountDao);
}
