package com.example.demo.service;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.vo.PageVo;

import java.util.List;

public interface CommodityInfoService {

    public List<CommodityInfo> findAll();

    public PageVo findCommodityInfoPages(int categoryId,int currentPage);

    public CommodityInfo findById(String cid);
}

