package com.project.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.travel.entity.SessionEntity;
import com.project.travel.entity.UserEntity;
import com.project.travel.repository.SessionRepo;
import com.project.travel.repository.UserRepo;

@Service
public class AuthorisationService {

    @Autowired
    public UserRepo repo;

    @Autowired
    public SessionRepo srepo;

    public String registerUser(UserEntity e) {
        
        repo.save(e);
        return "Successfully logged in";
    }

    public String loginUser(String email , String password) {
        
        UserEntity u = repo.findByEmailAndPasswordHash(email, password);
        SessionEntity s = new SessionEntity();
        s.setUser(u);
        s.setIsActive(true);
        srepo.save(s);
        return "Login Successfull";
    }

    public String logoutUser(int id) {
       
        SessionEntity s= new SessionEntity();
        s.setIsActive(false);
        srepo.save(s);
        return "Logged out ";
    }

    public String verifyEmail(long id) {
        UserEntity u = repo.findById(id).orElseThrow();
        u.setEmailVerified(true);
        repo.save(u);
        return "Verified";
    }

    public String resetPass(Long id, String pass) {
        UserEntity u = repo.findById(id).orElseThrow();
        u.setPasswordHash(pass);
        repo.save(u);
        return "Password Changed";
    }
    
}
