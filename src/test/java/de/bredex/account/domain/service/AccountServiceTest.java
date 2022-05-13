package de.bredex.account.domain.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.bredex.account.domain.model.Account;
import de.bredex.account.domain.spi.AccountEntity;
import de.bredex.account.domain.spi.AccountRepository;

public class AccountServiceTest {

    private AccountRepository repository = mock(AccountRepository.class);
    
    private AccountService service;
    
    @BeforeEach
    public void setUp() {
	service = new AccountService(repository);
    }
    
    @Test
    public void getAccounts_returns_accounts() {
	List<AccountEntity> storedAccounts = new LinkedList<>();
	storedAccounts.add(new AccountEntity("000001", "Max", "Mustermann"));
	storedAccounts.add(new AccountEntity("000002", "Petra", "Musterfrau"));
	when(repository.findAll()).thenReturn(storedAccounts);
	
	List<Account> accounts = service.getAccounts();
	
	assertThat(accounts.size()).isEqualTo(2);
    }
}
