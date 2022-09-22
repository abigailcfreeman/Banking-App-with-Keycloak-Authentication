package com.ironhack.hellokeycloak.httprequests;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserRequest {
    String username;
    String password;
    String email;
    String firstname;
    String lastname;
    String phoneNumber;
}