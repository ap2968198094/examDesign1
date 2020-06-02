package com.example.demo.service.impl;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.repository.CommodityInfoRepository;
import com.example.demo.service.CommodityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityInfoServiceImpl implements CommodityInfoService {

    @Autowired
    private CommodityInfoRepository repository;
    @Override
    public List<CommodityInfo> findAll() {
        return repository.findAll();
    }
}
