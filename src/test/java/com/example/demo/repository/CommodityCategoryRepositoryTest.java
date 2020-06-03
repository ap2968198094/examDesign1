package com.example.demo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommodityCategoryRepositoryTest {
    @Autowired
    private CommodityCategoryRepository repository;
    @Test
    void find(){
        System.out.println(repository.findAll());
    }

}