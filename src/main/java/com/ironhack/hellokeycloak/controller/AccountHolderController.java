package com.ironhack.hellokeycloak.controller;

import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/owner")
public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountService accountService;
    @Autowired
    TransactionService transactionService;


    //GET BALANCE
    @GetMapping("/balance/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public BigDecimal returnBalance(@PathVariable Long id) {
        return accountService.returnBalance(id);
    }

}