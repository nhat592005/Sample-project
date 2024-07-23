package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.repository.enity.DistrictEnity;
import com.example.demo.repository.enity.RentAreaEnity;
import com.example.demo.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepositoryImpl;
    @Autowired
    private DistrictRepository districtRepositoryImpl;
    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Override
    public List<BuildingFullEnities> findAll(Map<String, Object> params, List<String> typeCode) {
        // cai này là cái drop từ cái responsities và service là xywr lý nó
        // buildingrepository.findAll la mot ham hung lay data
        List<BuildingEnity> buildingEnities = buildingRepositoryImpl.findAll(params, typeCode);
        // result chua du lieu de tra ve cho view
        List<BuildingFullEnities> result = new ArrayList<>();
        // fileter loc
        // item duyet qua tat ca buildingEnitites
        // khi day item se la coi như là buildingentities tức là nó sẽ kiếm đầy đủ các
        // chức của nó và khi drop thì item sẽ là ng nắm data
        for (BuildingEnity item : buildingEnities) {
            // bat dau ghep tu la xu lycac logic sau khi lay dc cac database
            // se de dang sau khi co duoc tat ca ca du kien
            BuildingFullEnities building = new BuildingFullEnities();
            building.setName(item.getName());
            DistrictEnity district = districtRepositoryImpl.findNameById(item.getDistrictid());
            building.setAdress(item.getStreet() + " " + item.getWard() + " " + district.getName());
            List<RentAreaEnity> rentArea = rentAreaRepository.getValueById(item.getId());
            String resultRentArea = rentArea.stream().map(i -> i.getValue().toString())
                    .collect(Collectors.joining(" ,"));
            building.setRentArea(resultRentArea);
            building.setNumberOfBasements(item.getNumberofbasement());
            building.setManagerName(item.getManagername());
            building.setManagerPhoneNumber(item.getManagerphonenumber());
            building.setFloorArea(item.getFloorarea());
            building.setRentPrice(item.getRentprice());
            building.setServiceFee(item.getServicefee());
            building.setBrokerageFee(item.getBrokeragefee());
            result.add(building);
        }
        return result;
    }

}
