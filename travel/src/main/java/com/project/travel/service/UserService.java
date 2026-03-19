package com.project.travel.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.travel.entity.SessionEntity;
import com.project.travel.entity.UserEntity;
import com.project.travel.repository.SessionRepo;
import com.project.travel.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private SessionRepo sessionRepo;

    public UserEntity register(UserEntity user) {
        user.setCreatedDate(LocalDateTime.now());
        return userRepo.save(user);
    }

    public String login(UserEntity user) {
        UserEntity existing = userRepo.findByEmail(user.getEmail());
        if (existing == null) {
            return "Invalid credentials: email not found";
        }

        if (!existing.getPasswordHash().equals(user.getPasswordHash())) {
            return "Invalid credentials: wrong password";
        }

        existing.setLastLogin(LocalDateTime.now());
        userRepo.save(existing);

        return "Login successful. Welcome " + existing.getFirstName() + "!";
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }
    
    public String logout() {
        return "User logged out";
    }

    public UserEntity getProfile(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public UserEntity updateProfile(Long id, UserEntity updated) {
        UserEntity existing = userRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setNationality(updated.getNationality());
        existing.setPassportNumber(updated.getPassportNumber());
        existing.setEmergencyContact(updated.getEmergencyContact());
        existing.setTravelPreferences(updated.getTravelPreferences());

        return userRepo.save(existing);
    }

    public String changePassword(Long id, String oldPass) {
        UserEntity existing = userRepo.findById(id).orElse(null);
        if (existing == null) return "User not found";
        existing.setPasswordHash(oldPass);
        userRepo.save(existing);
        return "Password changed successfully";
    }

    public List<SessionEntity> activeSessions(Long userId) {
        return sessionRepo.findByUserIdAndIsActiveTrue(userId);
    }

    public void terminateSession(Long sessionId) {
        sessionRepo.findById(sessionId).ifPresent(s -> {
            s.setIsActive(false);
            sessionRepo.save(s);
        });
    }
}
