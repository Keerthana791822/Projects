package com.project.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.travel.entity.UserEntity;
import com.project.travel.service.AuthorisationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class AuthorisationController {
    
    @Autowired
    public AuthorisationService service;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserEntity e) {

        return service.registerUser(e);
    }
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password) {

        return service.loginUser(email , password);
    }
    @PostMapping("/logout/{id}")
    public String logoutUser(@PathVariable int id) {

        return service.logoutUser(id);
    }
    @PostMapping("/verifyEmail/{id}")
    public String verifyEmail(@PathVariable long id) {
        
        return service.verifyEmail(id);
    }
    @PostMapping("/resetPass/{id}")
    public String resetPass(@PathVariable Long id, @RequestParam String pass) {
        
        return service.resetPass(id,pass);
    }
    
    
    
    
}
