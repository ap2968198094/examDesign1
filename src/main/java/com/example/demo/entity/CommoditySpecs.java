package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class CommoditySpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;//规格id
    private Integer commodityId;//商品id
    private String specsName;//规格名称
    private Integer specsStock;//剩余库存
    private BigDecimal specsPrice;//规格价格
    private String specsIcon;//规格图片
}
