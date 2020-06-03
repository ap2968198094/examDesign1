package com.example.demo.service.impl;

import com.example.demo.entity.CommodityCategory;
import com.example.demo.repository.CommodityCategoryRepository;
import com.example.demo.service.CommodityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommodityCategoryServiceImpl implements CommodityCategoryService {
    @Autowired
    private CommodityCategoryRepository repository;
    @Override
    public List<CommodityCategory> findAll() {
        return repository.findAll();
    }
}
