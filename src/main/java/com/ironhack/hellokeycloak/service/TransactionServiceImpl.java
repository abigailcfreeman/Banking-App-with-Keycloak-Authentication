package com.ironhack.hellokeycloak.service;

import com.github.fge.Frozen;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Money;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.repository.AccountHolderRepository;
import com.ironhack.hellokeycloak.repository.AccountRepository;
import com.ironhack.hellokeycloak.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    AccountHolderService accountHolderService;
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    AccountHolderRepository accountHolderRepository;

    @Override
    public List<TransactionDTO> findAll() {
        var all = transactionRepository.findAll();
        List<TransactionDTO> allDTO = new ArrayList<>();
        for (Transaction transaction : all) {
            allDTO.add(TransactionDTO.fromEntity(transaction));
        }
        return allDTO;
    }

    @Override
    public TransactionDTO create(Long sender, Long receiver, TransactionDTO transactionDTO) {
       var TransactionDTO1 =  transactionDTO;
       TransactionDTO1.setSender(sender);
       TransactionDTO1.setReceiver(receiver);
        var entity = Transaction.fromDTO(sender, receiver, TransactionDTO1);
        var storedMember = transactionRepository.save(entity);

        Money currentBalance = accountService.returnBalance(sender);
        Money amountToSend = entity.getAmount();
        if(currentBalance.getAmount().compareTo(amountToSend.getAmount()) < 0 || accountService.findByOwnerId(sender).get().getStatus() == "frozen"){
            try {
                throw new Exception("no");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            accountService.updateBalance(sender, receiver,amountToSend.getAmount());
        }


        return transactionDTO.fromEntity(storedMember);
    }
    @Override
    public TransactionDTO create(Long sender, Long receiver, String hash, TransactionDTO transactionDTO) {
        var TransactionDTO1 =  transactionDTO;
        TransactionDTO1.setSender(sender);
        TransactionDTO1.setReceiver(receiver);
        var entity = Transaction.fromDTO(sender, receiver, TransactionDTO1);
        var storedMember = transactionRepository.save(entity);
        Money currentBalance = accountService.returnBalance(sender);
        Money amountToSend = entity.getAmount();
        if(currentBalance.getAmount().compareTo(amountToSend.getAmount()) < 0 || accountService.findByOwnerId(sender).get().getStatus() == "frozen"){
            try {
                throw new Exception("no");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            accountService.updateBalance(sender, receiver,amountToSend.getAmount());
        }


        return transactionDTO.fromEntity(storedMember);
    }

    @Override
    public TransactionDTO create(Principal principal, Long receiver, TransactionDTO transactionDTO) {
        Long sender = accountHolderService.findAccountByUuid(principal.getName()).get().getId();
        var TransactionDTO1 =  transactionDTO;
        TransactionDTO1.setSender(sender);
        TransactionDTO1.setReceiver(receiver);
        var entity = Transaction.fromDTO(sender, receiver, TransactionDTO1);
        var storedMember = transactionRepository.save(entity);

        Money currentBalance = accountService.returnBalance(sender);
        Money amountToSend = entity.getAmount();
        if(currentBalance.getAmount().compareTo(amountToSend.getAmount()) < 0 || accountService.findByOwnerId(sender).get().getStatus() == "frozen"){
            try {
                throw new Exception("no");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        else{
            accountService.updateBalance(sender, receiver,amountToSend.getAmount());
        }


        return transactionDTO.fromEntity(storedMember);
    }

    @Override
    public List<Transaction> findAllBySender(Long sender){
        return transactionRepository.findAllBySender(sender);
    }

    @Override
    public Optional<Transaction> findById(long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public List<Transaction> findAllbyUuid(Principal principal){
       AccountHolder accountHolder =  accountHolderRepository.findAccountHolderByUuid(principal.getName());
        return transactionRepository.findAllBySender(accountHolder.getId());
    }

}
