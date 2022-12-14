package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Money;

import java.math.BigDecimal;
import java.security.Principal;
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
    void updateBalance(Long owner, Long receiver, BigDecimal amount);

    // CreateNewAccount
    AccountDTO create(Long owner, AccountDTO accountDTO);


    //Get balance Authorized
    Money returnBalance(Principal principal);

    //Get balance third party
    Money returnBalance(Long owner);

    // Delete account
    void delete(Long id);

}