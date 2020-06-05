package com.example.demo.repository;

import com.example.demo.entity.CommodityOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CommodityOrderRepositoryTest {
    @Autowired
    private OrderRepository repository;
    @Test
    void find(){
        List<CommodityOrder> li = repository.findAll();
        for (CommodityOrder commodityOrder : li) {
            System.out.println(commodityOrder);
        }
    }

}