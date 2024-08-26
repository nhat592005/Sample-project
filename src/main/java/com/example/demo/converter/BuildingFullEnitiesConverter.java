package com.example.demo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.repository.entity.RentAreaEntity;

//co the su dung service hoac components;
//tuc la nhiem vu cua cai nay la lay du lieu tu repository và phân lọc để chuyển sang serive 
//viết ở service cx dc nma dài và không nên 

@Component
// primary la ưu tiên hàm khi implement khi chung một interfare buildingrepo
@Primary
public class BuildingFullEnitiesConverter {
    @Autowired
    private ModelMapper modelMapper;

    public BuildingFullEnities BuildingConverter(BuildingEntity item) {
        // model mapper là đã lấy hết tất cả dữ liệu cùng tên giữa setter và getter bên full và field bên BUildingEnity
        // còn những cái như name hay adress thì phải set riêng
        // sau đó chuyển ra ngoài
        BuildingFullEnities building = modelMapper.map(item, BuildingFullEnities.class);
        building.setAdress(item.getStreet() + " " + item.getWard() + " " + item.getDistrict().getName());
        List<RentAreaEntity> rentArea = item.getItems();
        // map = filter ;
        // Collectors.joing la them 1 chu cai truoc 1 bvong lap
        String resultRentArea = rentArea.stream().map(i -> i.getValue().toString())
                .collect(Collectors.joining(" ,"));
        building.setRentArea(resultRentArea);
        return building;
    }
}
