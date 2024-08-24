package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.DistrictRepository;
import com.example.demo.repository.RentAreaRepository;
import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.repository.enity.DistrictEnity;
import com.example.demo.repository.enity.RentAreaEnity;

//co the su dung service hoac components;
//tuc la nhiem vu cua cai nay la lay du lieu tu repository và phân lọc để chuyển sang serive 
//viết ở service cx dc nma dài và không nên 

@Component
public class BuildingFullEnitiesConverter {
    @Autowired
    private DistrictRepository districtRepositoryImpl;
    @Autowired
    private RentAreaRepository rentAreaRepository;
    @Autowired
    private ModelMapper modelMapper;

    public BuildingFullEnities BuildingConverter(BuildingEnity item) {
        // model mapper là đã lấy hết tất cả dữ liệu cùng tên r
        // còn những cái như name hay adress thì phải set riêng
        // sau đó chuyển ra ngoài
        BuildingFullEnities building = modelMapper.map(item, BuildingFullEnities.class);
        building.setName(item.getName());
        DistrictEnity district = districtRepositoryImpl.findNameById(item.getDistrict());
        building.setAdress(item.getStreet() + " " + item.getWard() + " " + district.getName());
        List<RentAreaEnity> rentArea = rentAreaRepository.getValueById(item.getId());
        // map = filter ;
        // Collectors.joing la them 1 chu cai truoc 1 bvong lap
        String resultRentArea = rentArea.stream().map(i -> i.getValue().toString())
                .collect(Collectors.joining(" ,"));
        building.setRentArea(resultRentArea);
        return building;
    }
}
