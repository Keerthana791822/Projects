package com.project.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.travel.entity.SessionEntity;
import com.project.travel.entity.UserEntity;
import com.project.travel.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired 
    private UserService userService;

    @GetMapping("/profile/{id}") 
    public UserEntity profile(@PathVariable Long id) 
    { 
        return userService.getProfile(id); 
    }
    @PutMapping("/profile/{id}") 
    public UserEntity update(@PathVariable Long id, @RequestBody UserEntity u) 
    { 
        return userService.updateProfile(id, u); 
    }
    @PostMapping("/change-password/{id}") 
    public void change(@PathVariable Long id, @RequestParam String pass) 
    { 
        userService.changePassword(id, pass); 
    }
    @GetMapping("/{id}/sessions") 
    public List<SessionEntity> sessions(@PathVariable Long id) 
    { 
        return userService.activeSessions(id); 
    }
    @DeleteMapping("/sessions/{id}") 
    public void terminate(@PathVariable Long id) 
    { 
        userService.terminateSession(id); 
    }
}
