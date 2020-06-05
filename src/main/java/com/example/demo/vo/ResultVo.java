package com.example.demo.vo;

import lombok.Data;

/**
 * 封装返回结果
 * @param <T>
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
