package com.example.demo.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//day co the duoc coi la javabean nơi hứng dữ lieju của tất cả và từ đó trôi và phân lọc ra các bean bên ngoài 
//nơi lấy database từ mysql
@Entity
@Table(name = "building")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // còn đây nếu là districtid là khóa ngoại và nghĩa là mỗi building chỉ có chứa
    // 1 district
    @ManyToOne(fetch = FetchType.LAZY)
    // tuc la no tao luon column districtid vs nó là khóa ngoại
    @JoinColumn(name = "districtid")
    private DistrictEntity district;

    @OneToMany(mappedBy = "building")
    private List<RentAreaEntity> items = new ArrayList<>();

    @Column(name = "name")
    private String name;
    @Column(name = "ward")
    private String ward;
    @Column(name = "street")
    private String street;
    @Column(name = "numberofbasement")
    private Integer numberofbasement;
    // @Column(name = "districtid")
    // private Long districtid;
    @Column(name = "managername")
    private String managername;
    @Column(name = "servicefee")
    private String servicefee;
    @Column(name = "managerphonenumber")
    private String managerphonenumber;
    @Column(name = "floorarea")
    private Long floorarea;
    @Column(name = "rentprice")
    private Long rentprice;
    @Column(name = "brokeragefee")
    private Long brokeragefee;
    @Column(name = "rentpricedescription")
    private String rentpricedescription;

    public List<RentAreaEntity> getItems() {
        return items;
    }

    public void setItems(List<RentAreaEntity> items) {
        this.items = items;
    }

    public DistrictEntity getDistrict() {
        return district;
    }
    //lưu ý này
    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

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

    // public Long getDistrictid() {
    // return districtid;
    // }

    // public void setDistrictid(Long districtid) {
    // this.districtid = districtid;
    // }

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
                + numberofbasement + ", districtid=" + ", managername=" + managername + ", servicefee="
                + servicefee + ", managerphonenumber=" + managerphonenumber + ", floorarea=" + floorarea
                + ", rentprice=" + rentprice + ", brokeragefee=" + brokeragefee + "]";
    }

    public String getRentpricedescription() {
        return rentpricedescription;
    }

    public void setRentpricedescription(String rentpricedescription) {
        this.rentpricedescription = rentpricedescription;
    }
}
