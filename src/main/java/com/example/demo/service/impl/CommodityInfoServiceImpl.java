package com.example.demo.service.impl;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.repository.CommodityInfoRepository;
import com.example.demo.service.CommodityInfoService;
import com.example.demo.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PageVo findCommodityInfoPages(int categoryId,int currentPage) {
        PageVo pageVo = new PageVo();
        pageVo.setCurrentPage(currentPage);
        pageVo.setPageSize(5);
        int totolCount = repository.findCountById(categoryId);
        pageVo.setTotalCount(totolCount);
        if (totolCount % 5 == 0){
            pageVo.setTotalPage(pageVo.getTotalCount()/5);
        } else {
            pageVo.setTotalPage(pageVo.getTotalCount()/5+1);
        }
        List<CommodityInfo> list = repository.findAllById(categoryId);
        List<CommodityInfo> li = new ArrayList<>();
        if (currentPage*5 > totolCount){
            for (int i = (currentPage-1)*5; i < totolCount; i++) {
                li.add(list.get(i));
            }
            pageVo.setList(li);
        }else {
            for (int i = (currentPage-1)*5; i < currentPage*5; i++) {
                li.add(list.get(i));
            }
            pageVo.setList(li);
        }

        return pageVo;
    }

    @Override
    public CommodityInfo findById(String cid) {
        return repository.findById(Integer.parseInt(cid)).get();
    }


}
