package com.ironhack.hellokeycloak.DTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.hellokeycloak.model.Account;
import com.ironhack.hellokeycloak.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    @JsonIgnore
    private Long sender;
    @JsonIgnore
    private Long receiver;
    private BigDecimal amount;
    private String fromAccountName;
    private String toAccountName;


    public static TransactionDTO fromEntity(Transaction entity) {
        var transactionNew = new TransactionDTO();
        transactionNew.setAmount(entity.getAmount());
        transactionNew.setFromAccountName(entity.getFromAccountName());
        transactionNew.setToAccountName(entity.getToAccountName());

        return transactionNew;
    }
}