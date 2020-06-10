package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Favorite {
    @Id
    private Integer commodityId;
    private Integer userId;
}
