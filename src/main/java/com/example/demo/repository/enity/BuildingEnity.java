package com.example.demo.repository.enity;

//day co the duoc coi la javabean nơi hứng dữ lieju của tất cả và từ đó trôi và phân lọc ra các bean bên ngoài 
public class BuildingEnity {
    private String name;
    private String ward;
    private String street;
    private long numberofbasement;
    private long districtid;
    private String managername;
    private String servicefee;
    private String managerphonenumber;
    private long floorarea;
    private long rentprice;
    private long brokeragefee;
    private long id;

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

    public long getNumberofbasement() {
        return numberofbasement;
    }

    public void setNumberofbasement(long numberofbasement) {
        this.numberofbasement = numberofbasement;
    }

    public long getDistrictid() {
        return districtid;
    }

    public void setDistrictid(long districtid) {
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

    public long getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(long floorarea) {
        this.floorarea = floorarea;
    }

    public long getRentprice() {
        return rentprice;
    }

    public void setRentprice(long rentprice) {
        this.rentprice = rentprice;
    }

    public long getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(long brokeragefee) {
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
