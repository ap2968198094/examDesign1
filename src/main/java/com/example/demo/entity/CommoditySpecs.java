package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author 雍知晓 商品规格
 */
@Data
@Entity
public class CommoditySpecs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer specsId;
    private Integer commodityId;
    private String specsName;
    private Integer specsStock;
    private String specsPrice;
    private String specsIcon;
}
