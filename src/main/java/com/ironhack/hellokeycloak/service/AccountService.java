package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.model.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountService {

    // AllChecking
    List<AccountDTO> findAll();

    // FindById
    Optional<Account> findById(Long id);

    //Find by Owner ID
    Optional<Account> findByOwnerId(Long owner);

    //Update balance
    void updateBalance(Long owner, BigDecimal amount);

    // CreateNewAccount
    AccountDTO create(Long owner, AccountDTO accountDTO);

    BigDecimal returnBalance(Long owner);

    // DeleteChecking
    void delete(long id);

}