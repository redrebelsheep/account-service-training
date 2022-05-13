package de.bredex.account.application.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bredex.account.domain.logic.AccountService;

@RestController
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/api/v1/account")
    public List<AccountDto> getAccounts() {
	return service.getAccounts().stream()
		.map(account -> new AccountDto(account.getFirstName(), account.getLastName()))
		.collect(Collectors.toList());
    }
}
