package com.example.demo.repository;

import com.example.demo.entity.CommodityCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommodityCategoryRepository extends JpaRepository<CommodityCategory,Integer> {
}
