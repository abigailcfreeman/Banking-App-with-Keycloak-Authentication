package com.ironhack.hellokeycloak.controller;
import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountService accountService;

    @Autowired
    TransactionService transactionService;

    //CREATE BANK ACCOUNT
    @PostMapping("/create/account/{owner}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createaccountAccount(@PathVariable Long owner, @RequestBody AccountDTO accountDTO) {
        accountService.create(owner, accountDTO);
    }

    //FIND BANK ACCOUNT BY ID
    @GetMapping("/find/account/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<Account> findById(@PathVariable Long id) {
        return accountService.findById(id);
    }

    //CREATE ACCOUNT HOLDER
    @PostMapping("/create/holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolderDTO createAccountHolder(@RequestBody AccountHolderDTO accountHolderDTO) {
        return accountHolderService.create(accountHolderDTO);
    }

    //GET ALL ACCOUNT HOLDERS
    @GetMapping("/return/holders")
    @ResponseStatus(HttpStatus.FOUND)
    public List<AccountHolderDTO> findAllHolders() {
        return accountHolderService.findAll();
    }

    //FIND ACCOUNT HOLDER BY ID
    @GetMapping("/find/holder/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    public Optional<AccountHolder> findHolderById(@PathVariable Long id) {
        return accountHolderService.findById(id);
    }


    //CREATE TRANSACTION
    @PostMapping ("/sendfrom/{sender}/to/{receiver}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO createTransaction(@PathVariable Long receiver, Long sender, @RequestBody TransactionDTO transactionDTO) {
        return transactionService.create(sender, receiver, transactionDTO);
    }
}