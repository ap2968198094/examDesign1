package com.example.demo.util;

import com.example.demo.vo.ResultVo;

public class ResultVoUtil {

    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo error(String error){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(1);
        resultVo.setMsg("error");
        resultVo.setData(error);
        return resultVo;
    }
}
