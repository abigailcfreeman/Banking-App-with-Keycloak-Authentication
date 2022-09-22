package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.repository.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionRepository transactionRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findAll() {

    }

    @Test
    void create() {
    }

    @Test
    void findAllBySender() {
    }

    @Test
    void findById() {
    }
}