package com.example.demo.repository.enity;
//day co the duoc coi la javabean nơi hứng dữ lieju của tất cả và từ đó trôi và phân lọc ra các bean bên ngoài 
public class BuildingEnity {
    private String name ; 
    private String numberofbasement;
    private String ward;
    private String street;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumberofbasement() {
        return numberofbasement;
    }
    public void setNumberofbasement2(String string) {
        this.numberofbasement = string;
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
    public void setNumberofbasement(String string) {
        throw new UnsupportedOperationException("Unimplemented method 'setNumberofbasement'");
    }    
}
