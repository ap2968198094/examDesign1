package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 雍知晓  收藏夹
 */
@Entity
@Data
public class Favorite {
    @Id
    private Integer commodityId;
    private Integer userId;
}
