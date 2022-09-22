package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountDTO;
import com.ironhack.hellokeycloak.DTO.ThirdPartyDTO;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.ThirdParty;
import com.ironhack.hellokeycloak.repository.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThirdPartyServiceImpl implements ThirdPartyService {

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

   @Autowired
   TransactionService transactionService;

    @Override
    public List<ThirdPartyDTO> findAll() {
        var all = thirdPartyRepository.findAll();
        List<ThirdPartyDTO> allDTO = new ArrayList<>();
        for (ThirdParty thirdParty : all) {
            allDTO.add(ThirdPartyDTO.fromEntity(thirdParty));
        }
        return allDTO;
    }

    @Override
    public ThirdPartyDTO create(ThirdPartyDTO thirdPartyDTO) {
        var entity = ThirdParty.fromDTO(thirdPartyDTO);
        var storedMember = thirdPartyRepository.save(entity);

        return thirdPartyDTO.fromEntity(storedMember);
    }
}
