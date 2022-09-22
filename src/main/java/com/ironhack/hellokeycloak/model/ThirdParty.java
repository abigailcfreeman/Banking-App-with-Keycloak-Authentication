package com.ironhack.hellokeycloak.model;

import com.ironhack.hellokeycloak.DTO.ThirdPartyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ThirdParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String hashedKey;

        public static ThirdParty fromDTO(ThirdPartyDTO dto){
            var thirdpartyNew = new ThirdParty();
            thirdpartyNew.setName(dto.getName());
            thirdpartyNew.setHashedKey(dto.getHashedKey());

            return thirdpartyNew;
        }
}