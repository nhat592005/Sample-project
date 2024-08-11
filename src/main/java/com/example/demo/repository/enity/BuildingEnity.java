package com.example.demo.repository.enity;

//day co the duoc coi la javabean nơi hứng dữ lieju của tất cả và từ đó trôi và phân lọc ra các bean bên ngoài 
//nơi lấy database từ mysql
public class BuildingEnity {
    private String name;
    private String ward;
    private String street;
    private Integer numberofbasement;
    private Long districtid;
    private String managername;
    private String servicefee;
    private String managerphonenumber;
    private Long floorarea;
    private Long rentprice;
    private Long brokeragefee;
    private Long id;

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

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(Integer numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getManagerphonenumber() {
        return managerphonenumber;
    }

    public void setManagerphonenumber(String managerphonenumber) {
        this.managerphonenumber = managerphonenumber;
    }

    public Long getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(Long floorarea) {
        this.floorarea = floorarea;
    }

    public Long getRentprice() {
        return rentprice;
    }

    public void setRentprice(Long rentprice) {
        this.rentprice = rentprice;
    }

    public Long getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(Long brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

    @Override
    public String toString() {
        return "BuildingEnity [name=" + name + ", ward=" + ward + ", street=" + street + ", numberofbasement="
                + numberofbasement + ", districtid=" + districtid + ", managername=" + managername + ", servicefee="
                + servicefee + ", managerphonenumber=" + managerphonenumber + ", floorarea=" + floorarea
                + ", rentprice=" + rentprice + ", brokeragefee=" + brokeragefee + "]";
    }
}
