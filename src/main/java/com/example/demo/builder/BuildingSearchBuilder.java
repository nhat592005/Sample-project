package com.example.demo.Builder;

import java.util.ArrayList;
import java.util.List;

//viec lam cái builder này giúp mỗi hàm tranh cái việc có 3 tham só ;
//cai nay su dung cho repository ko phai ket qua cua service
//nhiệm vụ cái này là rút gọn nững thamsoo mà chỉ còn đúing 1 cái tham số duy nhất

public class BuildingSearchBuilder {
    private String name;
    private Long floorarea;
    private String ward;
    private String street;
    private Integer numberofbasement;
    private Long districtid;
    private String managername;
    private String servicefee;
    private String managerphonenumber;
    private Long rentpricefrom;
    private Long rentpriceto;
    private Long areafrom;
    private Long areato;
    private Long staffid;
    private Long level;
    private List<String> typeCode = new ArrayList<>();

    private BuildingSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.floorarea = builder.floorarea;
        this.ward = builder.ward;
        this.street = builder.street;
        this.numberofbasement = builder.numberofbasement;
        this.districtid = builder.districtid;
        this.managername = builder.managername;
        this.servicefee = builder.servicefee;
        this.managerphonenumber = builder.managerphonenumber;
        this.rentpricefrom = builder.rentpricefrom;
        this.rentpriceto = builder.rentpriceto;
        this.areafrom = builder.areafrom;
        this.areato = builder.areato;
        this.staffid = builder.staffid;
        this.level = builder.level;
        this.typeCode = builder.typeCode;
    }

    public String getName() {
        return name;
    }

    public Long getFloorarea() {
        return floorarea;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public Integer getNumberofbasement() {
        return numberofbasement;
    }

    public Long getDistrictid() {
        return districtid;
    }

    public String getManagername() {
        return managername;
    }

    public String getServicefee() {
        return servicefee;
    }

    public String getManagerphonenumber() {
        return managerphonenumber;
    }

    public Long getRentpricefrom() {
        return rentpricefrom;
    }

    public Long getRentpriceto() {
        return rentpriceto;
    }

    public Long getAreafrom() {
        return areafrom;
    }

    public Long getAreato() {
        return areato;
    }

    public Long getStaffid() {
        return staffid;
    }

    public Long getLevel() {
        return level;
    }

    public List<String> getTypeCode() {
        return typeCode;
    }

    public static class Builder {
        private String name;
        private Long floorarea;
        private String ward;
        private String street;
        private Integer numberofbasement;
        private Long districtid;
        private String managername;
        private String servicefee;
        private String managerphonenumber;
        private Long rentpricefrom;
        private Long rentpriceto;
        private Long areafrom;
        private Long areato;
        private Long staffid;
        private Long level;
        private List<String> typeCode = new ArrayList<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setFloorarea(Long floorarea) {
            this.floorarea = floorarea;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setNumberofbasement(Integer numberofbasement) {
            this.numberofbasement = numberofbasement;
            return this;
        }

        public Builder setDistrictid(Long districtid) {
            this.districtid = districtid;
            return this;
        }

        public Builder setManagername(String managername) {
            this.managername = managername;
            return this;
        }

        public Builder setServicefee(String servicefee) {
            this.servicefee = servicefee;
            return this;
        }

        public Builder setManagerphonenumber(String managerphonenumber) {
            this.managerphonenumber = managerphonenumber;
            return this;
        }

        public Builder setRentpricefrom(Long rentpricefrom) {
            this.rentpricefrom = rentpricefrom;
            return this;
        }

        public Builder setRentpriceto(Long rentpriceto) {
            this.rentpriceto = rentpriceto;
            return this;
        }

        public Builder setAreafrom(Long areafrom) {
            this.areafrom = areafrom;
            return this;
        }

        public Builder setAreato(Long areato) {
            this.areato = areato;
            return this;
        }

        public Builder setStaffid(Long staffid) {
            this.staffid = staffid;
            return this;
        }

        public Builder setLevel(Long level) {
            this.level = level;
            return this;
        }

        public Builder setTypeCode(List<String> typeCode) {
            this.typeCode = typeCode;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }
}
