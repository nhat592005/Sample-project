package com.example.demo;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.BuildingDTO;
import com.example.demo.Repository.Interface.BuildingRepository;
import com.example.demo.Repository.entity.BuildingEntity;
import com.example.demo.Service.impl.BuildingServiceImpl;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.GetMapping;
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
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/api/building/search/")
    public List<BuildingDTO> getBuilding(@RequestParam(required = false) Map<String, Object> params,
            @RequestParam(value = "typeCode", required = false) List<String> typeCode) {
        // khi đó tầng view sẽ phải xuống service để tìm dữ liệu
        List<BuildingDTO> result = buildingService.findAll(params, typeCode);
        return result;
    }

    @PutMapping("/api/add")
    @Transactional
    public void add(@RequestBody BuildingEntity buildingEntity) {
        buildingRepository.save(buildingEntity);
        System.out.println("ok thanh cong");
    }

    @PostMapping("/api/update")
    @Transactional
    public void update(@RequestBody BuildingEntity buildingEntity) {
        // truoc tien la phai lay du lieu no ra theo id
        BuildingEntity building = buildingRepository.findById(buildingEntity.getId()).get();
        modelMapper.map(buildingEntity, building);
        buildingRepository.save(building);
        System.out.println("Ok da update xong");
    }

    @Transactional
    @PutMapping("/api/building/search/")
    public void Searchingbyname(@RequestParam String name) {
        List<BuildingEntity> result = buildingRepository.findByNameContaining(name);
        System.out.println("OK thành công");
        for (BuildingEntity item : result) {
            System.out.println(item.toString());
        }
    }

    @DeleteMapping("/api/building/search/{ids}")
    @Transactional
    public void xoa(@PathVariable Long[] ids) {
        //cai nay la ham tu tao cu them In la thanh Long 
        buildingRepository.deleteByIdIn(ids);
        System.out.println("OK thành công");
    }

}
