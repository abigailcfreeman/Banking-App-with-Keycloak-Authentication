package com.ironhack.hellokeycloak.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.AccountHolder;
import com.ironhack.hellokeycloak.service.AccountHolderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private BigDecimal balance;
    public LocalDate creationDate;
    private String status;

    @JsonIgnore
    private Long accountHolder;


    public static AccountDTO fromEntity(Account entity) {
        var checkingDtoNew = new AccountDTO();
        checkingDtoNew.setBalance(entity.getBalance());
        checkingDtoNew.setCreationDate(entity.getCreationDate());
        checkingDtoNew.setStatus(entity.getStatus());
        checkingDtoNew.setAccountHolder(entity.getAccountHolder());
        return checkingDtoNew;
    }


}