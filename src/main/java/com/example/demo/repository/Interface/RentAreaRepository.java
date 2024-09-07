package com.example.demo.Repository.Interface;

import java.util.List;

import com.example.demo.Repository.entity.RentAreaEntity;

public interface RentAreaRepository {
    public List<RentAreaEntity> getValueById(Long id);
}
