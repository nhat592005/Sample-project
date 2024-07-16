package com.example.demo.repository.enity;
//quan va choose là tìm kiếm theo id tức là phải join 
//areafrom là từ rentarea
//giá thuê là rentprice
public class BuildingFullEnities {
    public String name;
    public Integer floorarea;
    public Integer districtID;
    public String ward; 
    public String street ; 
    public Integer numberofbasement;
    public String direction ;
    public String level;
    public String managername;
    public String managerphonenumber;
    public Integer areafrom;
    public Integer areato;
    public Integer rentpricefrom;
    public Integer rentpriceto;
    //typecode la noithat tang tren hay nguyen can 
    public String typeCode;
    public Integer staffID;

    @Override
    public String toString() {
        return "BuildingFullEnities [name=" + name + ", floorarea=" + floorarea + ", districtID=" + districtID
                + ", ward=" + ward + ", street=" + street + ", numberofbasement=" + numberofbasement + ", direction="
                + direction + ", level=" + level + ", managername=" + managername + ", managerphonenumber="
                + managerphonenumber + ", areafrom=" + areafrom + ", areato=" + areato + ", rentpricefrom="
                + rentpricefrom + ", rentpriceto=" + rentpriceto + ", typeCode=" + typeCode + ", staffID=" + staffID
                + "]";
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getFloorarea() {
        return floorarea;
    }
    public void setFloorarea(Integer floorarea) {
        this.floorarea = floorarea;
    }
    public Integer getDistrictID() {
        return districtID;
    }
    public void setDistrictID(Integer districtID) {
        this.districtID = districtID;
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
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getLevel() {
        return level;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getManagername() {
        return managername;
    }
    public void setManagername(String managername) {
        this.managername = managername;
    }
    public String getManagerphonenumber() {
        return managerphonenumber;
    }
    public void setManagerphonenumber(String managerphonenumber) {
        this.managerphonenumber = managerphonenumber;
    }
    public Integer getAreafrom() {
        return areafrom;
    }
    public void setAreafrom(Integer areafrom) {
        this.areafrom = areafrom;
    }
    public Integer getAreato() {
        return areato;
    }
    public void setAreato(Integer areato) {
        this.areato = areato;
    }
    public Integer getRentpricefrom() {
        return rentpricefrom;
    }
    public void setRentpricefrom(Integer rentpricefrom) {
        this.rentpricefrom = rentpricefrom;
    }
    public Integer getRentpriceto() {
        return rentpriceto;
    }
    public void setRentpriceto(Integer rentpriceto) {
        this.rentpriceto = rentpriceto;
    }
    public String getTypeCode() {
        return typeCode;
    }
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }
    public Integer getStaffID() {
        return staffID;
    }
    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    } 
}
