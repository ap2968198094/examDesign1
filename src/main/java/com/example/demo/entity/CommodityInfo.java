package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Data
@Entity
public class CommodityInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commodityId;
    private String commodityName;
    private String commodityPrice;
    private String commodityDescription;
    private Integer commodityStock;//库存
    private String commodityIcon;
    private Integer commodityCategory;
}
