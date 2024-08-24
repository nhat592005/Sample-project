package com.example.demo.repository.enity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEnity {
    // id la da tu tao column r
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // ten role
    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserRoleEnity> roleEnities = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<UserRoleEnity> getRoles() {
        return roleEnities;
    }

    public void setRoles(List<UserRoleEnity> roles) {
        this.roleEnities = roles;
    }

}
