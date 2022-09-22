package com.ironhack.hellokeycloak.model;

import com.ironhack.hellokeycloak.DTO.AdminDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String uuid;

        public static Admin fromDTO(AdminDTO dto){
            var adminNew = new Admin();
            adminNew.setName(dto.getName());
            adminNew.setUuid(dto.getUuid());
            return adminNew;
        }
}