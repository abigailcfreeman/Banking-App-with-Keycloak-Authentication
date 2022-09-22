package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

    // AllTransactions
    List<TransactionDTO> findAll();

    // FindById
    Optional<Transaction> findById(long id);

    // CreateTransaction
    TransactionDTO create(Long sender, Long receiver, TransactionDTO transactionDTO);

}