package com.example.demo.repository.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_role")
public class UserRoleEnity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roleid")
    private RoleEnity role;

    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEnity user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleEnity getRole() {
        return role;
    }

    public void setRole(RoleEnity role) {
        this.role = role;
    }

    public UserEnity getUser() {
        return user;
    }

    public void setUser(UserEnity user) {
        this.user = user;
    }

}
