package com.ironhack.hellokeycloak.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ironhack.hellokeycloak.DTO.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

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

    @Column
    @NotNull
    @Size(min = 300)
    public BigDecimal balance;

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
        checkingNew.setBalance(dto.getBalance());
        checkingNew.setCreationDate(dto.getCreationDate());
        checkingNew.setStatus(dto.getStatus());
        checkingNew.setAccountType(dto.getAccountType());
        checkingNew.setAccountHolder(owner);
        return checkingNew;
    }

}