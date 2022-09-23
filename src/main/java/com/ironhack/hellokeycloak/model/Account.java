package com.ironhack.hellokeycloak.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.hellokeycloak.DTO.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="account_holder_id")
    private Long accountHolder;

    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance"))
    })
    @Embedded
    public Money balance;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column
    public LocalDate creationDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column
    public AccountType accountType;

    @Column
    @NotNull
    private String status;


    public static Account fromDTO(Long owner, AccountDTO dto){
        var checkingNew = new Account();
        var balance = new Money(dto.getBalance());
        checkingNew.setBalance(balance);
        checkingNew.setCreationDate(dto.getCreationDate());
        checkingNew.setStatus(dto.getStatus());
        checkingNew.setAccountType(dto.getAccountType());
        checkingNew.setAccountHolder(owner);
        return checkingNew;
    }
}