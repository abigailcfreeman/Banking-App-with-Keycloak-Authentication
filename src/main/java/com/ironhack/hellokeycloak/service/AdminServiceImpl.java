package com.ironhack.hellokeycloak.service;

import com.ironhack.hellokeycloak.DTO.AdminDTO;
import com.ironhack.hellokeycloak.model.Admin;
import com.ironhack.hellokeycloak.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public AdminDTO create(AdminDTO adminDTO) {
        var entity = Admin.fromDTO(adminDTO);
        var storedMember = adminRepository.save(entity);

        return adminDTO.fromEntity(storedMember);
    }
}