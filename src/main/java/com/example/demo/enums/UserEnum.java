package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum UserEnum {
    USER_NOT_EXIST(0,"该用户不存在");

    private Integer code;
    private String msg;
    UserEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
