package com.example.demo.enums;

import lombok.Getter;

/**
 * @author 雍知晓
 */

@Getter
public enum UserEnum {
    USER_NOT_EXIST(0,"该用户不存在"),
    USERNAME_OR_PASSWORD_NOT_TRUE(1,"用户名或密码错误"),
    LOGIN_SUCCESS(2,"登陆成功"),
    USER_NOT_ACTIVE(3,"用户未激活"),
    USER_ACTIVE_SUCCESS(4,"用户激活成功"),
    USERNAME_EXIT(5,"用户名已存在");

    private Integer code;
    private String msg;
    UserEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
