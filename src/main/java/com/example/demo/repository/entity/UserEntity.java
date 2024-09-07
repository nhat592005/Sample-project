package com.example.demo.Repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, unique = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "email")
    private String email;

    //nen tao se k co id
    @ManyToMany(fetch = FetchType.LAZY)
    // jointable la table trung gian
    // jointable co 3 tham so can dien vao
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "userid", nullable = false), inverseJoinColumns = @JoinColumn(name = "roleid", nullable = false))
    private List<RoleEntity> roles = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

}
