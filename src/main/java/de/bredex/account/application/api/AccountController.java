package de.bredex.account.application.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/api/v1/account")
    public String getAccounts() {
	return "hello world!";
    }
}
