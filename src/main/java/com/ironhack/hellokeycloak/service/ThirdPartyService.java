package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.DTO.ThirdPartyDTO;
import com.ironhack.hellokeycloak.DTO.TransactionDTO;
import com.ironhack.hellokeycloak.model.ThirdParty;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ThirdPartyService {

    //Get All Third Parties
    List<ThirdPartyDTO> findAll();

    // Create New Third Party
    ThirdPartyDTO create(ThirdPartyDTO thirdPartyDTO);
}
