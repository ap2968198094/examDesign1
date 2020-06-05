package com.example.demo.repository;

import com.example.demo.entity.CommodityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityInfoRepository extends JpaRepository<CommodityInfo,Integer> {
    @Query(nativeQuery = true,value = "select * from commodity_info limit ?1,?2 where commodity_category = ?3")
    public List<CommodityInfo> findCommodityInfoPages(int start,int end,int categoryId);

    @Query(nativeQuery = true,value = "select count(*) from commodity_info where commodity_category = ?")
    public Integer findCountById(int categoryId);

    @Query(nativeQuery = true,value = "select * from commodity_info where commodity_category = ?")
    public List<CommodityInfo> findAllById(int categoryId);

    public List<CommodityInfo> findByCommodityNameLike(String name);

}
