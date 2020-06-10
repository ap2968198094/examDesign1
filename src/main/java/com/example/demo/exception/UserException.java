package com.example.demo.exception;

import com.example.demo.enums.UserEnum;
import org.springframework.web.bind.annotation.PutMapping;

public class UserException extends RuntimeException {

    public  UserException(UserEnum userEnum){
        super(userEnum.getMsg());

    }
    public UserException(String error){
        super(error);
    }
}
