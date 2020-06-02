package com.example.demo.service.impl;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.repository.CommodityInfoRepository;
import com.example.demo.service.CommodityInfoService;
import com.example.demo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @Override
    public PageVo findCommodityInfoPages(int currentPage) {
        PageVo pageVo = new PageVo();
        pageVo.setCurrentPage(currentPage);
        pageVo.setPageSize(5);
        int totolCount = (int)repository.count();
        pageVo.setTotalCount(totolCount);
        if (totolCount % 5 == 0){
            pageVo.setTotalPage(pageVo.getTotalCount()/5);
        } else {
            pageVo.setTotalPage(pageVo.getTotalCount()/5+1);
        }

        if (currentPage*5 > totolCount){
            pageVo.setList(repository.findCommodityInfoPages((currentPage-1)*5,totolCount));
        }else {
            pageVo.setList(repository.findCommodityInfoPages((currentPage-1)*5,currentPage*5));
        }

        return pageVo;
    }


}
