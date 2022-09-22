package com.ironhack.hellokeycloak.DTO;
import com.ironhack.hellokeycloak.model.AccountHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountHolderDTO {

    private String name;
    public Date dob;
    private String phone;

    //Address
    private String street;
    private String country;
    private String postalCode;

    public static AccountHolderDTO fromEntity(AccountHolder entity) {
        var accountDtoNew = new AccountHolderDTO();
        accountDtoNew.setName(entity.getName());
        accountDtoNew.setDob(entity.getDob());
        accountDtoNew.setPhone(entity.getPhone());

        if (entity.getAddress() != null) {
            accountDtoNew.setStreet(entity.getAddress().getStreet());
            accountDtoNew.setCountry(entity.getAddress().getCountry());
            accountDtoNew.setPostalCode(entity.getAddress().getPostalCode());
        }

        return accountDtoNew;
    }

}
