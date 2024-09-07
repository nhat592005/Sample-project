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
@Table(name = "district")
public class DistrictEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;
    // nếu k ghi fetch type thì nó sẽ mặc định là lazy
    // nó giống kiểu search theo id nếu có districtid thì sẽ hiện ra tất cả
    // buildingenity
    // 1 district có thể chứa nhiều building
    @OneToMany(mappedBy = "district")
    private List<BuildingEntity> items = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

}
