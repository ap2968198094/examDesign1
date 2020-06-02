package com.example.demo.repository;

import com.example.demo.entity.CommodityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityInfoRepository extends JpaRepository<CommodityInfo,Integer> {
    @Query(nativeQuery = true,value = "select * from commodity_info limit ?1,?2")
    public List<CommodityInfo> findCommodityInfoPages(int start,int end);

}
