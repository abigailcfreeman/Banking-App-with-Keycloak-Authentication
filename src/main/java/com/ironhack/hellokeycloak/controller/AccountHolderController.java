package com.ironhack.hellokeycloak.controller;

import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/member")
public class AccountHolderController {
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountService accountService;
    @Autowired
    TransactionService transactionService;


    //GET BALANCE
    @GetMapping("/balance")
    @ResponseStatus(HttpStatus.FOUND)
    public BigDecimal returnBalance(Principal principal) {
        return accountService.returnBalance(principal);
    }

    //GET ALL TRANSACTIONS FROM ACCOUNT
    @GetMapping("/return/transactions")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Transaction> findAllTransactionsById(Principal principal) {
        return transactionService.findAllbyUuid(principal);
    }

    //CREATE TRANSACTION
    @PostMapping ("/send-to/{receiver}/")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO createTransaction(Principal principal, @PathVariable Long receiver, @RequestBody TransactionDTO transactionDTO) {
        return transactionService.create(principal, receiver, transactionDTO);
    }

    //CHANGE NAME PATCH
    @PatchMapping("/name")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void changeName(Principal principal, @RequestBody AccountHolder name) {
        accountHolderService.changeName(principal, name);
    }
}