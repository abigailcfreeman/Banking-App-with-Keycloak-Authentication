package com.ironhack.hellokeycloak.DTO;

import com.ironhack.hellokeycloak.model.ThirdParty;
import com.ironhack.hellokeycloak.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThirdPartyDTO {

    private Long id;
    private String name;
    private String hashedKey;

    public static ThirdPartyDTO fromEntity(ThirdParty entity) {
        var thirdPartyNew = new ThirdPartyDTO();
        thirdPartyNew.setName(entity.getName());
        thirdPartyNew.setHashedKey(entity.getHashedKey());

        return thirdPartyNew;
    }

}
