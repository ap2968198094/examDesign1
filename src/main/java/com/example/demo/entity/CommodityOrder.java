package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author 雍知晓 商品订单
 */
@Data
@Entity
public class CommodityOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderPrice;
    private String orderStatus = "N";
    private Integer userId;
}
