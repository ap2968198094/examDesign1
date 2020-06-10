package com.example.demo.service;

import com.example.demo.entity.CommodityCategory;

import java.util.List;
import java.util.Locale;

public interface CommodityCategoryService {
    /**
     * 查找所有商品分类
     * @return
     */
    public List<CommodityCategory> findAll();
}
