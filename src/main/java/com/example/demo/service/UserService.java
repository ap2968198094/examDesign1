package com.example.demo.service;



import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    public Boolean regist(User user);
    public List<User> findAll();
    public User findByUsername(String username);
    public Boolean active(String code);

    Boolean login(User user);
}
