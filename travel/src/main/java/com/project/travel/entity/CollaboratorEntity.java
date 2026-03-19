package com.project.travel.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="collaborators")
public class CollaboratorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Many collaborators belong to one itinerary
    @ManyToOne
    @JoinColumn(name = "itinerary_id", nullable = false)
    private ItenaryEntity itinerary;

    // Many collaborators belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private PermissionLevel permissionLevel;

    private LocalDateTime invitedDate;
    private LocalDateTime acceptedDate;

    @Enumerated(EnumType.STRING)
    private CollaboratorStatus status;

    public enum PermissionLevel { VIEW, EDIT, OWNER }
    public enum CollaboratorStatus { INVITED, ACCEPTED, DECLINED }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ItenaryEntity getItinerary() {
        return itinerary;
    }
    public void setItinerary(ItenaryEntity itinerary) {
        this.itinerary = itinerary;
    }
    public UserEntity getUser() {
        return user;
    }
    public void setUser(UserEntity user) {
        this.user = user;
    }
    public PermissionLevel getPermissionLevel() {
        return permissionLevel;
    }
    public void setPermissionLevel(PermissionLevel permissionLevel) {
        this.permissionLevel = permissionLevel;
    }
    public LocalDateTime getInvitedDate() {
        return invitedDate;
    }
    public void setInvitedDate(LocalDateTime invitedDate) {
        this.invitedDate = invitedDate;
    }
    public LocalDateTime getAcceptedDate() {
        return acceptedDate;
    }
    public void setAcceptedDate(LocalDateTime acceptedDate) {
        this.acceptedDate = acceptedDate;
    }
    public CollaboratorStatus getStatus() {
        return status;
    }
    public void setStatus(CollaboratorStatus status) {
        this.status = status;
    }
    
}
