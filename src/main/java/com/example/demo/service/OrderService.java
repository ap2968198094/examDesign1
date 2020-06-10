package com.example.demo.service;

import com.example.demo.entity.CommodityOrder;

import java.util.List;

public interface OrderService {
    /**
     * 根据订单编号查找订单
     * @param id
     * @return
     */
    public CommodityOrder findById(int id);

    /**
     * 保存订单
     * @param order
     */
    public void save(CommodityOrder order);

    /**
     * 查找所有订单
     * @return
     */
    public List<CommodityOrder> findAll();
}
