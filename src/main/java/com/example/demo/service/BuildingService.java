package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.bean.BuildingFullEnities;

public interface BuildingService {
    List<BuildingFullEnities> findAll(Map<String, Object> params, List<String> typeCode);
}
