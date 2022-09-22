package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.model.Transaction;
import com.ironhack.hellokeycloak.repository.TransactionRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionRepository transactionRepository;

    Transaction t1;
    Transaction t2;
    Transaction t3;

    List<Transaction> transactions;


    @BeforeEach
    void setUp() {
        transactionRepository.deleteAll();
        transactions = List.of(
                t1 = new Transaction(3L, 2L, 4L, new BigDecimal(300), "Abby", "Josiah"),
                t2 = new Transaction(2L, 3L, 1L, new BigDecimal(200), "Andrew", "Josiah"),
                t3 = new Transaction(1L, 3L, 2L, new BigDecimal(100), "Josiah", "Abby")
        );
        transactionRepository.saveAll(transactions);
    }

    @Test
    void test_save_3_ok() {
        assertEquals(3, transactionRepository.count());
    }

    @Test
    void findById() {
        Optional found = transactionRepository.findById(1L);
        assertEquals(1, found);
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


}