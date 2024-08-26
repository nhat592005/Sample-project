package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.builder.BuildingSearchBuilder;
import com.example.demo.converter.BuildingFullEnitiesConverter;
import com.example.demo.converter.BuildingSearchBuilderConverter;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepositoryImpl;
    @Autowired
    private BuildingFullEnitiesConverter BuildingFullEnitiesConverter;
    @Autowired
    private BuildingSearchBuilderConverter buildingSearchBuilderConverter;

    @Override
    public List<BuildingFullEnities> findAll(Map<String, Object> params, List<String> typeCode) {
        // cai này là cái drop từ cái responsities và service là xywr lý nó
        // buildingrepository.findAll la mot ham hung lay data
        // tao 1 bean de lay tat du lieu tu cai search builder duoi tang repo
        BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.tobBuildingSearchBuilder(params,
                typeCode);
        List<BuildingEntity> buildingEnities = buildingRepositoryImpl.findAll(buildingSearchBuilder);
        // result chua du lieu de tra ve cho view
        List<BuildingFullEnities> result = new ArrayList<>();
        // fileter loc
        // item duyet qua tat ca buildingEnitites
        // khi day item se la coi như là buildingentities tức là nó sẽ kiếm đầy đủ các
        // chức của nó và khi drop thì item sẽ là ng nắm data
        for (BuildingEntity item : buildingEnities) {
            // bat dau ghep tu la xu lycac logic sau khi lay dc cac database
            // se de dang sau khi co duoc tat ca ca du kien
            BuildingFullEnities building = new BuildingFullEnities();
            // ghep cac du lieu
            // cai cocnverter này sẽ chuyển đổi và set up dữ liệu từ repo về đây
            // ham converter này đã filter và chắt lọc để giảm độ dài và nheiefu dữ liệu của
            // service
            building = BuildingFullEnitiesConverter.BuildingConverter(item);
            result.add(building);
        }
        return result;
    }

}
