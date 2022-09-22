package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AccountHolderService {

    // AllAccountHolders
    List<AccountHolderDTO> findAll();


    // FindByHolderID
    Optional<AccountHolder> findById(long id);

    // CreateNewAccountHolder
    AccountHolderDTO create(AccountHolderDTO accountHolderDTO);

    // UpdateAccountHolder
    AccountHolderDTO update(long id, AccountHolderDTO accountHolderDTO);

    // DeleteAccountHolder
    void delete(long id);

}