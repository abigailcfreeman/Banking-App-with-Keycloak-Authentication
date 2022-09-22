package com.ironhack.hellokeycloak.DTO;

import com.ironhack.hellokeycloak.model.Admin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {

    private String name;
    private String uuid;

        public static AdminDTO fromEntity(Admin entity) {
            var adminDtoNew = new AdminDTO();
            adminDtoNew.setName(entity.getName());
            adminDtoNew.setUuid(entity.getUuid());
            return adminDtoNew;
        }
}