package com.ironhack.hellokeycloak.repository;

import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findAllBySender(Long sender);
}