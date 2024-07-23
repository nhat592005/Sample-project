package com.example.demo.repository;

import com.example.demo.repository.enity.DistrictEnity;

public interface DistrictRepository {
    DistrictEnity findNameById(Long value);
}
