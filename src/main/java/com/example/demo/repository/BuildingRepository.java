package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.enity.BuildingEnity;

@Repository
public interface BuildingRepository {
    List<BuildingEnity> findAll(Map<String, Object> params, List<String> typeCode);
}
