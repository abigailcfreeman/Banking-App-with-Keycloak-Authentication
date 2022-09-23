package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.repository.AccountHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Component
public class AccountHolderServiceImpl implements AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public List<AccountHolderDTO> findAll() {
        var all = accountHolderRepository.findAll();
        List<AccountHolderDTO> allDTO = new ArrayList<>();
        for (AccountHolder accountHolder : all) {
            allDTO.add(AccountHolderDTO.fromEntity(accountHolder));
        }
        return allDTO;
    }

    @Override
    public AccountHolderDTO create(AccountHolderDTO accountHolderDTO) {
        var entity = AccountHolder.fromDTO(accountHolderDTO);
        var storedMember = accountHolderRepository.save(entity);

        return accountHolderDTO.fromEntity(storedMember);
    }


    @Override
    public Optional<AccountHolder> findById(long id) {
        return accountHolderRepository.findById(id);
    }


    @Override
    public AccountHolderDTO update(long id, AccountHolderDTO accountHolderDTO) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
    @Override
    public Optional<AccountHolder> findByPhone(String phone){
        return accountHolderRepository.findAccountHolderByPhone(phone);
    }

    @Override
    public Optional<AccountHolder> findAccountByUuid(String uuid){
        return Optional.ofNullable(accountHolderRepository.findAccountHolderByUuid(uuid));
    }

}
