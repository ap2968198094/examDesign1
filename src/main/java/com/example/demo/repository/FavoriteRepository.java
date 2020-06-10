package com.example.demo.repository;

import com.example.demo.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Integer> {
    /**
     * 根据用户id查找所有的收藏商品信息
     * @param id
     * @return
     */
    @Query(nativeQuery = true,value = "select * from favorite where user_id = ?")
    public List<Favorite> findAllById(int id);
}
