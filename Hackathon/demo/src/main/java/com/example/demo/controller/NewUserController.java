package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewUserController {

    @PostMapping("/saveUser")
    public void saveNewUser(@RequestBody String newUser){
        System.out.println(newUser);
    }

    @GetMapping("/health-check")
    public String getHealth(){return "App is healthy is the, we are wealthy is the";}
}
