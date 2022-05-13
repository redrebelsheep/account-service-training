package de.bredex.account.application.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/api/v1/account")
    public List<AccountDto> getAccounts() {
	List<AccountDto> result = new ArrayList<AccountDto>();
	
	result.add(new AccountDto("Timo", "Rohrberg"));
	result.add(new AccountDto("Max", "Mustermann"));
	result.add(new AccountDto("Petra", "Musterfrau"));
	
	return result;
    }
}
