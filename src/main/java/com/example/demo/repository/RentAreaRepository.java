package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.enity.RentAreaEnity;

public interface RentAreaRepository {
    public List<RentAreaEnity> getValueById(Long id);
}
