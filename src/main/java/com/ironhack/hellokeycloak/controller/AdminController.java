package com.ironhack.hellokeycloak.controller;
import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.DTO.ThirdPartyDTO;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.ThirdPartyService;
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

    @Autowired
    ThirdPartyService thirdPartyService;

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


    //DELETE BANK ACCOUNT BY ID
    @DeleteMapping("/delete/account/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        accountService.delete(id);
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


    //GET ALL TRANSACTIONS
    @GetMapping("/return/transactions")
    @ResponseStatus(HttpStatus.FOUND)
    public List<TransactionDTO> findAllTransactions() {
        return transactionService.findAll();
    }

    //CREATE THIRD PARTY
    @PostMapping("/create/third-party")
    @ResponseStatus(HttpStatus.CREATED)
    public void createThirdParty(@RequestBody ThirdPartyDTO thirdPartyDTO) {
        thirdPartyService.create(thirdPartyDTO);
    }
}