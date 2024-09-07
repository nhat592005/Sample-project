package com.example.demo.Repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "renttype")
public class RentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name ="code")
    private String code ;  
    @OneToMany(mappedBy = "renttype")
    private List<BuildingRentTypeEntity> buildingRentTypeEntities = new ArrayList<>();
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
    public List<BuildingRentTypeEntity> getBuildingRentTypeEntities() {
        return buildingRentTypeEntities;
    }
    public void setBuildingRentTypeEntities(List<BuildingRentTypeEntity> buildingRentTypeEntities) {
        this.buildingRentTypeEntities = buildingRentTypeEntities;
    }

}
