package com.example.demo.repository;

import com.example.demo.entity.CommodityInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommodityInfoRepository extends JpaRepository<CommodityInfo,Integer> {
    /**
     * 范围查找
     * @param start
     * @param end
     * @return
     */
    @Query(nativeQuery = true,value = "select * from commodity_info limit ?1,?2")
    public List<CommodityInfo> findCommodityInfoPages(int start,int end);

    /**
     * 根据id查找总数
     * @param categoryId
     * @return
     */
    @Query(nativeQuery = true,value = "select count(*) from commodity_info where commodity_category = ?")
    public Integer findCountById(int categoryId);

    /**
     * 根据分类id查找所有商品信息
     * @param categoryId
     * @return
     */
    @Query(nativeQuery = true,value = "select * from commodity_info where commodity_category = ?")
    public List<CommodityInfo> findAllById(int categoryId);

    /**
     * 根据名字模糊查询所有商品信息
     * @param name
     * @return
     */
    public List<CommodityInfo> findByCommodityNameLike(String name);


}
