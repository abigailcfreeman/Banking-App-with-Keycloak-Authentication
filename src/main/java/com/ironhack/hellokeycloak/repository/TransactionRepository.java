package com.ironhack.hellokeycloak.repository;

import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        List<Transaction> findAllBySender(Long sender);
        Optional<Transaction>findById(Long id);
}