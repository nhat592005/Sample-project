package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import com.example.demo.bean.BuildingFullEnities;
import com.example.demo.repository.enity.BuildingEnity;

public interface BuildingRepository {
    List<BuildingEnity> findAll(String name, Long districtid);

    List<BuildingFullEnities> search(Map<String, String> map);
}
