package com.ironhack.hellokeycloak.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    private String hello(Principal principal){
        return "hello " + principal.getName();
    }

    @GetMapping("/admin")
    private String helloAdmin(Principal principal){
        return "hello " + principal.getName() + ", you are an ADMIN";
    }

    @GetMapping("/open")
    private String helloOpen(){
        return "hello, you are accessing an OPEN endpoint!";
    }
}
