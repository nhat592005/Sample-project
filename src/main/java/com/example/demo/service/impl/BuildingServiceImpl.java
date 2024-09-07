package com.example.demo.Service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Builder.BuildingSearchBuilder;
import com.example.demo.Converter.BuildingDTOConverter;
import com.example.demo.Converter.BuildingSearchBuilderConverter;
import com.example.demo.DTO.BuildingDTO;
import com.example.demo.Repository.Interface.BuildingRepository;
import com.example.demo.Repository.entity.BuildingEntity;
import com.example.demo.Service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingDTOConverter BuildingFullEnitiesConverter;
    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Override
    public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode) {
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.tobBuildingSearchBuilder(params,
                typeCode);
        List<BuildingEntity> buildingEnities = buildingRepository.findAll(buildingSearchBuilder);   
        // result chua du lieu de tra ve cho view
        List<BuildingDTO> result = new ArrayList<>();
        for (BuildingEntity item : buildingEnities) {
            BuildingDTO building = BuildingFullEnitiesConverter.BuildingConverter(item);
            result.add(building);
        }
        return result;
    }

}
