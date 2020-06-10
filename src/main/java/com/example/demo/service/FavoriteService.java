package com.example.demo.service;

import com.example.demo.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    /**
     * 保存收藏
     * @param favorite
     */
    public void save(Favorite favorite);

    /**
     * 根据用户id查找所有收藏商品
     * @param id
     * @return
     */
    public List<Favorite> findAllById(int id);
}
