package com.example.demo.service;

import com.example.demo.entity.CommodityOrder;

import java.util.List;

public interface OrderService {
    public CommodityOrder findById(int id);
    public void save(CommodityOrder order);
    public List<CommodityOrder> findAll();
}
