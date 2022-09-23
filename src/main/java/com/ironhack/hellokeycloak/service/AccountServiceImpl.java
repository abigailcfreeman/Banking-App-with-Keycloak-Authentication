package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.repository.AccountHolderRepository;
import com.ironhack.hellokeycloak.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderService accountHolderService;

    @Autowired
    AccountHolderRepository accountHolderRepository;


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
    public BigDecimal returnBalance(Principal principal){
     AccountHolder accountHolder =  accountHolderRepository.findAccountHolderByUuid(principal.getName());
        return accountRepository.findAccountByAccountHolder(accountHolder.getId()).get().getBalance();
    }

    @Override
    public BigDecimal returnBalance(Long owner){
        return accountRepository.findAccountByAccountHolder(owner).get().getBalance();
    }

    @Override
    public void updateBalance(Long owner, Long receiver, BigDecimal amount){
        Account sender = accountRepository.findAccountByAccountHolder(owner).get();
        BigDecimal newBalance = sender.getBalance().subtract(amount);
        sender.setBalance(newBalance);
        accountRepository.save(sender);

        Account getter = accountRepository.findAccountByAccountHolder(receiver).get();
        BigDecimal newBalance2 = getter.getBalance().add(amount);
        getter.setBalance(newBalance2);
        accountRepository.save(getter);
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
