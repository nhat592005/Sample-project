package com.example.demo.Repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    // String hay int cx k bi sao van chuyen doi het sang string tren class
    @Column(name = "value")
    public String value;

    // many to one co san fet lazy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buildingid")
    //nhớ cái kia building phải cùng tên vs cái mappedby bên onetomany
    private BuildingEntity building;

    public BuildingEntity getBuilding() {
        return building;
    }

    public void setBuilding(BuildingEntity building) {
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
