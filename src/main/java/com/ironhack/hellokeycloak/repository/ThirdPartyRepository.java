package com.ironhack.hellokeycloak.repository;

import com.ironhack.hellokeycloak.DTO.ThirdPartyDTO;
import com.ironhack.hellokeycloak.model.ThirdParty;
import com.ironhack.hellokeycloak.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThirdPartyRepository extends JpaRepository<ThirdParty, Long> {

}