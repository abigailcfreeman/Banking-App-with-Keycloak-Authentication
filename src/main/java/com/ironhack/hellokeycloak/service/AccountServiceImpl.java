package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderService accountHolderService;

    @Override
    public List<AccountDTO> findAll() {
        var all = accountRepository.findAll();
        List<AccountDTO> allDTO = new ArrayList<>();
        for (Account account : all) {
            allDTO.add(AccountDTO.fromEntity(account));
        }
        return allDTO;
    }

    @Override
    public Optional <Account> findByOwnerId(Long owner){
        return accountRepository.findAccountByAccountHolder(owner);
    }


    @Override
    public AccountDTO create(Long owner, AccountDTO accountDTO) {

        var entity = Account.fromDTO(owner, accountDTO);
        var storedMember = accountRepository.save(entity);

        return accountDTO.fromEntity(storedMember);
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public BigDecimal returnBalance(Long id){
        return accountRepository.findById(id).get().getBalance();
    }

    @Override
    public void updateBalance(Long owner, BigDecimal amount){
     BigDecimal currentBalance =  accountRepository.findAccountByAccountHolder(owner).get().getBalance();
     BigDecimal newBalance = currentBalance.subtract(amount);
        accountRepository.findAccountByAccountHolder(owner).get().setBalance(newBalance);
    }

    @Override
    public void delete(long id) {

    }
}
