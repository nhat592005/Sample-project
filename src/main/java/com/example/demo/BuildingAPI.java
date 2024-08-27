package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.entity.BuildingEntity;
import com.example.demo.repository.entity.BuildingTestDTO;
import com.example.demo.repository.entity.DistrictEntity;
import com.example.demo.service.impl.BuildingServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


//tao ra cai controller de quan ly 4 yeu cau cua web
// import org.springframework.web.bind.annotation.PutMapping;
@RestController
public class BuildingAPI {
    @Autowired
    private BuildingServiceImpl buildingService;
    @Autowired
    private BuildingRepository buildingRepository;

    @GetMapping("/api/building/search/")
    public List<BuildingFullEnities> getBuilding(@RequestParam(required = false) Map<String, Object> params,
            @RequestParam(value = "typeCode", required = false) List<String> typeCode) {
        // khi đó tầng view sẽ phải xuống service để tìm dữ liệu
        List<BuildingFullEnities> result = buildingService.findAll(params, typeCode);
        return result;
    }

    @PersistenceContext
    EntityManager entityManager;
    //phải sử dụng transactional
    @Transactional
    @PostMapping("/api/building/search/")
    public void Testpersist(@RequestBody BuildingTestDTO buildingTestDTO) {
        BuildingEntity building = new BuildingEntity();
        building.setName(buildingTestDTO.getName());
        building.setWard(buildingTestDTO.getWard());
        building.setStreet(buildingTestDTO.getStreet());
        DistrictEntity districtEntity = new DistrictEntity();
        districtEntity.setId(buildingTestDTO.getDistrictid());
        building.setDistrict(districtEntity);
        building.setNumberofbasement(buildingTestDTO.getNumberofbasements());
        entityManager.persist(building);
        System.out.println("OK thành công");
    }

    @Transactional
    @PutMapping("/api/building/search/{name}")
    public List<BuildingEntity> Searchingbyname(@PathVariable String name) {
        List<BuildingEntity> result = buildingRepository.findByNameContaining(name);
        System.out.println("OK thành công");
        return result;
    }

    @DeleteMapping("/api/building/search/{ids}")
    @Transactional
    public void xoa(@PathVariable Long[] ids) {
        buildingRepository.deleteByIdIn(ids);
        System.out.println("OK thành công");
    }


}
