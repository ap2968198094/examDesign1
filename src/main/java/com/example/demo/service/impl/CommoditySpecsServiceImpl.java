package com.example.demo.service.impl;

import com.example.demo.entity.CommoditySpecs;
import com.example.demo.repository.CommoditySpecsRepository;
import com.example.demo.service.CommoditySpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommoditySpecsServiceImpl implements CommoditySpecsService {
    @Autowired
    private CommoditySpecsRepository repository;

    @Override
    public List<CommoditySpecs> findAll() {
        return repository.findAll();
    }
}
