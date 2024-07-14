package com.example.demo.bean;
//cai nay la kieu du lieu nguoi dung muốn phân lọc và hứng ữ liệu 
public class BuildingDTO {
    private String name; 
    private String street;
    private String ward ; 
    private String numberofbasement;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getWard() {
        return ward;
    }
    public void setWard(String ward) {
        this.ward = ward;
    }
    public String getNumberofbasement() {
        return numberofbasement;
    }
    public void setNumberofbasement(String integer) {
        this.numberofbasement = integer;
    }
    @Override
    public String toString() {
        return "BuildingDTO [name=" + name + ", street=" + street + ", ward=" + ward + ", numberofbasement="
                + numberofbasement + "]";
    }
    public void setNumberofbasement(Integer numberofbasement2) {
        throw new UnsupportedOperationException("Unimplemented method 'setNumberofbasement'");
    }
    
    

    
}
