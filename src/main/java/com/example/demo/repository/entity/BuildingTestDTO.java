package com.example.demo.repository.entity;


public class BuildingTestDTO {
    private String name;
    private String ward;
    private String street;
    private Long districtid;
    private Integer numberofbasement;
    
    public Integer getNumberofbasements() {
        return numberofbasement;
    }
    public void setNumberofbasements(Integer numberofbasements) {
        this.numberofbasement = numberofbasements;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public Long getDistrictid() {
        return districtid;
    }
    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    
}
