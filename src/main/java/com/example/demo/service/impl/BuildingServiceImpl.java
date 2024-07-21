package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.impl.BuildingRepositoryImpl;
import com.example.demo.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepositoryImpl buildingRepositoryImpl;

    @Override
    public List<BuildingFullEnities> findAll(Map<String, Object> params, List<String> typeCode) {
        // cai này là cái drop từ cái responsities và service là xywr lý nó
        // buildingrepository.findAll la mot ham hung lay data
        List<BuildingFullEnities> buildingEnities = buildingRepositoryImpl.findAll(params, typeCode);
        List<BuildingFullEnities> result = new ArrayList<>();
        // fileter loc
        // item duyet qua tat ca buildingEnitites
        // khi day item se la coi như là buildingentities tức là nó sẽ kiếm đầy đủ các
        // chức của nó và khi drop thì item sẽ là ng nắm data
        for (BuildingFullEnities item : buildingEnities) {
            //bat dau ghep tu la xu lycac logic sau khi lay dc cac database 
            BuildingFullEnities building = new BuildingFullEnities();
            building.
        }
        return result;
    }

}
