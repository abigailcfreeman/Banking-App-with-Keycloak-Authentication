package com.ironhack.hellokeycloak.repository;

import com.ironhack.hellokeycloak.model.AccountHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder, Long> {

    Optional<AccountHolder>findAccountHolderByPhone(String phone);

}