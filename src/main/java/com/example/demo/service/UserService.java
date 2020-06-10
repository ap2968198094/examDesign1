package com.example.demo.service;



import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user
     * @return
     */
    public Boolean regist(User user);

    /**
     * 查找所有用户
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 用户激活
     * @param code
     * @return
     */
    public Boolean active(String code);

    /**
     * 用户登录
     * @param user
     * @return
     */
    Boolean login(User user);
}
