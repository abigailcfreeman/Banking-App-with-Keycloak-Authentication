package com.ironhack.hellokeycloak.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.hellokeycloak.DTO.AccountHolderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class AccountHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public Date dob;

    @Column
    private String phone;

    @Embedded
    private Address address;

    @JsonIgnore
    @OneToMany
    List<Account>accounts;

    private String uuid;

    public static AccountHolder fromDTO(AccountHolderDTO dto){
        var accountHolderNew = new AccountHolder();
        accountHolderNew.setName(dto.getName());
        accountHolderNew.setDob(dto.getDob());
        accountHolderNew.setPhone(dto.getPhone());
        accountHolderNew.setUuid(dto.getUuid());

        var address = new Address();
        if (dto.getStreet() != null) address.setStreet(dto.getStreet());
        if (dto.getCountry() != null) address.setCountry(dto.getCountry());
        if (dto.getPostalCode() != null) address.setPostalCode(dto.getPostalCode());
        accountHolderNew.setAddress(address);

        return accountHolderNew;
    }
}