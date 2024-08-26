package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.entity.RentAreaEntity;

public interface RentAreaRepository {
    public List<RentAreaEntity> getValueById(Long id);
}
