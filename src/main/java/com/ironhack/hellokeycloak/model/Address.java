package com.ironhack.hellokeycloak.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String country;
    private String postalCode;


    public Address(String street, String country, String postalCode) {
        this.street = street;
        this.country = country;
        this.postalCode = postalCode;
    }

}