package com.example.demo.service.impl;

import com.example.demo.entity.Favorite;
import com.example.demo.repository.FavoriteRepository;
import com.example.demo.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    @Autowired
    private FavoriteRepository repository;
    @Override
    public void save(Favorite favorite) {
        repository.save(favorite);
    }

    @Override
    public List<Favorite> findAllById(int id) {
        return repository.findAllById(id);
    }
}
