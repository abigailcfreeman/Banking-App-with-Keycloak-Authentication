package com.ironhack.hellokeycloak.httprequests;

import lombok.Getter;

@Getter
public class LoginRequest {
    String username;
    String password;
}