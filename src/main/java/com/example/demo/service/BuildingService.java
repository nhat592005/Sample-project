package com.example.demo.service;

import java.util.List;

import com.example.demo.bean.BuildingDTO;

public interface BuildingService {
    List<BuildingDTO> findAll(String name , Long districtid);
}
