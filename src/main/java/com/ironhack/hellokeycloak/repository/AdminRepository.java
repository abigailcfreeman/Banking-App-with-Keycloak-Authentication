package com.ironhack.hellokeycloak.repository;

import com.ironhack.hellokeycloak.controller.AdminController;
import com.ironhack.hellokeycloak.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}