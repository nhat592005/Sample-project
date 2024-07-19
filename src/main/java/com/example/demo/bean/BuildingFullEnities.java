package com.example.demo.bean;

public class BuildingFullEnities {
    private String date;
    private String name;
    private String adress;
    private String numberofbasements;
    private String managername;
    private String managerphonenumber;
    private String floorarea;
    private String emptyarea;
    private String rentprice;
    private String servicefee;
    private String brokeragefee;
    private String rentarea;

    public String getRentarea() {
        return rentarea;
    }

    public void setRentarea(String rentarea) {
        this.rentarea = rentarea;
    }

    @Override
    public String toString() {
        return "BuildingFullEnities [date=" + date + ", name=" + name + ", adress=" + adress + ", numberofbasements="
                + numberofbasements + ", managername=" + managername + ", managerphone=" + managerphonenumber
                + ", floorarea="
                + floorarea + ", emptyarea=" + emptyarea + ", rentprice=" + rentprice + ", servicefee=" + servicefee
                + ", brokeragefee=" + brokeragefee + "]";
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getNumberofbasements() {
        return numberofbasements;
    }

    public void setNumberofbasements(String numberofbasements) {
        this.numberofbasements = numberofbasements;
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

    public void setManagerphonenumber(String managerphone) {
        this.managerphonenumber = managerphone;
    }

    public String getFloorarea() {
        return floorarea;
    }

    public void setFloorarea(String floorarea) {
        this.floorarea = floorarea;
    }

    public String getEmptyarea() {
        return emptyarea;
    }

    public void setEmptyarea(String emptyarea) {
        this.emptyarea = emptyarea;
    }

    public String getRentprice() {
        return rentprice;
    }

    public void setRentprice(String rentprice) {
        this.rentprice = rentprice;
    }

    public String getServicefee() {
        return servicefee;
    }

    public void setServicefee(String servicefee) {
        this.servicefee = servicefee;
    }

    public String getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(String brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

}
