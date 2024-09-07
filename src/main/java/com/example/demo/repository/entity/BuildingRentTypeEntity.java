package com.example.demo.Repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "buildingrenttype" )
public class BuildingRentTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "buildingid")
    private BuildingEntity building;

    @ManyToOne
    @JoinColumn(name = "renttypeid")
    private RentTypeEntity renttype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BuildingEntity getBuildingEntity() {
        return building;
    }

    public void setBuildingEntity(BuildingEntity buildingEntity) {
        this.building = buildingEntity;
    }

    public RentTypeEntity getRentTypeEntity() {
        return renttype;
    }

    public void setRentTypeEntity(RentTypeEntity rentTypeEntity) {
        this.renttype = rentTypeEntity;
    }


}
