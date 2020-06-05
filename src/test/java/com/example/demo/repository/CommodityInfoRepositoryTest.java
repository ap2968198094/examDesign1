package com.example.demo.repository;

import com.example.demo.entity.CommodityInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommodityInfoRepositoryTest {
    @Autowired
    private CommodityInfoRepository repository;

    @Test
    void find(){
        List<CommodityInfo> list = repository.findAll();
        Double s = 0.00;
        for (CommodityInfo commodityInfo : list) {
            s +=Double.parseDouble(commodityInfo.getCommodityPrice());
            System.out.println(Double.parseDouble(commodityInfo.getCommodityPrice()));
        }
        System.out.println(String.valueOf(s));

    }

}