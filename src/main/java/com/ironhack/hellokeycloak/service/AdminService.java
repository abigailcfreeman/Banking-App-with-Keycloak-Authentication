package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import com.ironhack.hellokeycloak.DTO.AdminDTO;
import com.ironhack.hellokeycloak.model.AccountHolder;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    // Create New Admin
    AdminDTO create(AdminDTO adminDTO);


}