package com.example.demo.service;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.vo.PageVo;

import java.util.List;

public interface CommodityInfoService {
    /**
     * 查找所有商品信息
     * @return
     */
    public List<CommodityInfo> findAll();

    /**
     * 根据分类id和当前页码封装pageBean对象.
     * @param categoryId
     * @param currentPage
     * @return
     */
    public PageVo findCommodityInfoPages(int categoryId,int currentPage);

    /**
     * 根据商品id查找商品信息
     * @param cid
     * @return
     */
    public CommodityInfo findById(String cid);

    /**
     * 根据名字模糊查询商品信息
     * @param name
     * @return
     */
    public List<CommodityInfo> findByCommodityNameLike(String name);

    /**
     * 根据当前页和一页多少条数据封装PageBean
     * @param page
     * @param limit
     * @return
     */
    PageVo findCommodityInfoPage(String page, String limit);

    /**
     * 根据当前页和limit以及商品类别封装PageBean.
     * @param page
     * @param limit
     * @param cid
     * @return
     */
    PageVo findCommodityInfoPageCategory(int page, int limit, int cid);

    /**
     * 保存商品信息
     * @param commodityInfo
     */
    public void save(CommodityInfo commodityInfo);
}

