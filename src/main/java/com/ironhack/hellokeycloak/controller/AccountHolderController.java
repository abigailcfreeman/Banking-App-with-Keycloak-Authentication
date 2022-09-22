package com.ironhack.hellokeycloak.controller;

import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

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

    //GET ALL TRANSACTIONS FROM ACCOUNT
    @GetMapping("/return/transactions/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Transaction> findAllTransactionsById(@PathVariable Long id) {
        return transactionService.findAllBySender(id);
    }

    //CREATE TRANSACTION
    @PostMapping ("/send-from/{sender}/to/{receiver}/")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO createTransaction(@PathVariable Long sender, @PathVariable Long receiver, @RequestBody TransactionDTO transactionDTO) {
        return transactionService.create(sender, receiver, transactionDTO);
    }
}