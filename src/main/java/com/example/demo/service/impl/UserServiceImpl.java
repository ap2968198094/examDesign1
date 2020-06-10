package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.enums.UserEnum;
import com.example.demo.exception.UserException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.MailUtils;
import com.example.demo.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean regist(User user) {
        User user1 = userRepository.findByUsername(user.getUsername());
        if (user1 != null){
            //�û������ڣ�ע��ʧ��
            log.error(UserEnum.USERNAME_EXIT.getMsg()+"user={}",user);
            return false;
        }
        //2.�����û���Ϣ
        //2.1���ü����룬Ψһ�ַ�
        user.setCode(UuidUtil.getUuid());
        //2.2���ü���״̬
        user.setStatus("N");
        userRepository.save(user);
        //�����ʼ����ͣ��ʼ�����
        String content = "<p>������������������,�븴�����ӵ��������http://localhost:8181/user/active/"+user.getCode()+"</p>";
        MailUtils.sendMail(user.getEmail(),content,"�����ʼ�");

        return true;
    }
    @Override
    public List<User> findAll(){
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Boolean active(String code) {
        User user = userRepository.findByCode(code);
        if (user == null){
            log.error(UserEnum.USER_NOT_EXIST.getMsg()+"user={}",user);
            return false;
        }
        user.setStatus("Y");
        log.info(UserEnum.USER_ACTIVE_SUCCESS.getMsg()+"user={}",user);
        userRepository.save(user);
        return true;
    }

    @Override
    public Boolean login(User user) {
        User user1 = null;
        try {
            user1 = userRepository
                    .findByUsernameAndPassword(
                            user.getUsername()
                            ,user.getPassword());
            if (user1 == null || user1.getStatus().equals("N")){
                log.error(UserEnum.USER_NOT_EXIST.getMsg()+"user1={}",user1);

                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


}
