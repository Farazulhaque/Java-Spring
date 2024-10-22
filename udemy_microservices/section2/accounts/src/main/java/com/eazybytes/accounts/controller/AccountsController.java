package com.eazybytes.accounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    /**
     * This method returns the accounts information.
     *
     * @return a string representing the accounts information
     */
    @GetMapping("/accounts")
    public String getAccounts() {
        return "Accounts";
    }

}
