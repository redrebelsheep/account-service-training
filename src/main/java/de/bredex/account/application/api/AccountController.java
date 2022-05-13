package de.bredex.account.application.api;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.bredex.account.domain.model.Account;
import de.bredex.account.domain.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/api/v1/account")
    public List<AccountDto> getAccounts() {
	return service.getAccounts().stream()
		.map(account -> new AccountDto(account.getNumber(), account.getFirstName(), account.getLastName()))
		.collect(Collectors.toList());
    }
    
    @PostMapping("/api/v1/account")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto account) {
	Account newAccount = service.createAccount(new Account(account.getFirstName(), account.getLastName()));
	return ResponseEntity.created(URI.create("/api/v1/account/" + newAccount.getNumber())).body(new AccountDto(newAccount.getNumber(), newAccount.getFirstName(), newAccount.getLastName()));
    }
}
