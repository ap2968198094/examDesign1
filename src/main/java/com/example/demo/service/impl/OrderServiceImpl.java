package com.example.demo.service.impl;

import com.example.demo.entity.CommodityOrder;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository repository;
    @Override
    public CommodityOrder findById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void save(CommodityOrder order) {
        repository.save(order);
    }

    @Override
    public List<CommodityOrder> findAll() {
        return repository.findAll();
    }
}
