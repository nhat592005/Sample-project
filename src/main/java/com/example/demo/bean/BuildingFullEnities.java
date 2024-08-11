package com.example.demo.bean;

public class BuildingFullEnities {
    private String name;
    private String adress;
    private Integer numberOfBasement;
    private String managerName;
    private String managerPhoneNumber;
    private Long floorArea;
    private String emptyArea;
    private Long rentPrice;
    private String serviceFee;
    private Long brokerageFee;
    private String rentArea;

    // còn đây là bean để database kết quả ;
    @Override
    public String toString() {
        return "BuildingFullEnities [name=" + name + ", adress=" + adress + ", numberOfBasements=" + numberOfBasement
                + ", managerName=" + managerName + ", managerPhoneNumber=" + managerPhoneNumber + ", floorArea="
                + floorArea + ", emptyArea=" + emptyArea + ", rentPrice=" + rentPrice + ", serviceFee=" + serviceFee
                + ", brokerageFee=" + brokerageFee + ", rentArea=" + rentArea + "]";
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

    public Integer getNumberOfBasements() {
        return numberOfBasement;
    }

    public void setNumberOfBasements(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPhoneNumber() {
        return managerPhoneNumber;
    }

    public void setManagerPhoneNumber(String managerPhoneNumber) {
        this.managerPhoneNumber = managerPhoneNumber;
    }

    public Long getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Long floorArea) {
        this.floorArea = floorArea;
    }

    public String getEmptyArea() {
        return emptyArea;
    }

    public void setEmptyArea(String emptyArea) {
        this.emptyArea = emptyArea;
    }

    public Long getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Long rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public Long getBrokerageFee() {
        return brokerageFee;
    }

    public void setBrokerageFee(Long brokerageFee) {
        this.brokerageFee = brokerageFee;
    }

    public String getRentArea() {
        return rentArea;
    }

    public void setRentArea(String rentArea) {
        this.rentArea = rentArea;
    }

}
