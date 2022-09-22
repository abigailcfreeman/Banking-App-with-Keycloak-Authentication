package com.ironhack.hellokeycloak.controller;

import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import com.ironhack.hellokeycloak.service.AccountService;
import com.ironhack.hellokeycloak.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/third-party")
public class ThirdPartyController {

    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountService accountService;
    @Autowired
    TransactionService transactionService;

    //CREATE TRANSACTION
    @PostMapping("/send-from/{sender}/to/{receiver}/hash-key/{hash}")
    @ResponseStatus(HttpStatus.OK)
    public TransactionDTO createTransaction(@PathVariable Long sender, @PathVariable Long receiver, @PathVariable String hash, @RequestBody TransactionDTO transactionDTO) {
        return transactionService.create(sender, receiver, transactionDTO);
    }
}
