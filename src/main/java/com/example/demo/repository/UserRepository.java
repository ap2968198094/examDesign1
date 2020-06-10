package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据激活码查找用户
     * @param code
     * @return
     */
    public User findByCode(String code);

    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return
     */
    public User findByUsernameAndPassword(String username, String password);
}
