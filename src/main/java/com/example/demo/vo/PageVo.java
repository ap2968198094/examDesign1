package com.example.demo.vo;

import com.example.demo.entity.CommodityInfo;
import lombok.Data;

import java.util.List;
@Data
public class PageVo {
    private int totalCount;//总记录数
    private int totalPage;//总页数
    private int currentPage;//当前页码
    private int pageSize;//每页显示的条数
    private List<CommodityInfo> list;//每页显示的数据集合
}
