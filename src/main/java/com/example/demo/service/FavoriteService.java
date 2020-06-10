package com.example.demo.service;

import com.example.demo.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    public void save(Favorite favorite);
    public List<Favorite> findAllById(int id);
}
