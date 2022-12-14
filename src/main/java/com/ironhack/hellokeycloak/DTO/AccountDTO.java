package com.ironhack.hellokeycloak.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.AccountType;
import com.ironhack.hellokeycloak.model.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private BigDecimal balance;
    public LocalDate creationDate;
    private AccountType accountType;
    private String status;

    @JsonIgnore
    private Long accountHolder;


    public static AccountDTO fromEntity(Account entity) {
        var checkingDtoNew = new AccountDTO();
        if (entity.getBalance() != null) {
            checkingDtoNew.setBalance(entity.getBalance().getAmount());
        }
        checkingDtoNew.setCreationDate(entity.getCreationDate());
        checkingDtoNew.setStatus(entity.getStatus());
        checkingDtoNew.setAccountType(entity.getAccountType());
        checkingDtoNew.setAccountHolder(entity.getAccountHolder());
        return checkingDtoNew;
    }



}