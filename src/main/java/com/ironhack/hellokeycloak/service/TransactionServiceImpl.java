package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.repository.AccountHolderRepository;
import com.ironhack.hellokeycloak.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

        //TOOD Check that funds are sufficient in sender account
        BigDecimal currentBalance = accountService.returnBalance(sender);
        BigDecimal amountToSend = entity.getAmount();

        accountService.updateBalance(sender, amountToSend);

        return transactionDTO.fromEntity(storedMember);
    }


    @Override
    public Optional<Transaction> findById(long id) {
        return transactionRepository.findById(id);
    }


}
