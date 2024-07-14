package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.BuildingDTO;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.enity.BuildingEnity;
import com.example.demo.service.BuildingService;
@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Override
    public List<BuildingDTO> findAll(String name , Long districid) {
        //cai này là cái drop từ cái responsities và service là xywr lý nó 
        //buildingrepository.findAll la mot ham hung lay data
        List<BuildingEnity> buildingEnities = buildingRepository.findAll(name , districid);
        List<BuildingDTO> result = new ArrayList<>();
        //fileter loc 
        //item duyet qua tat ca buildingEnitites
        //khi day item se la coi như là buildingentities tức là nó sẽ kiếm đầy đủ các chức của nó và khi drop thì item sẽ là ng nắm data
        for(BuildingEnity item : buildingEnities ){
            BuildingDTO building = new BuildingDTO();
            building.setName(item.getName());
            building.setStreet(item.getStreet());
            building.setWard(item.getWard());
            building.setNumberofbasement(item.getNumberofbasement());
            result.add(building);
        }
        return result;
    }
    
}
