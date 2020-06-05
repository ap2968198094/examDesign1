package com.example.demo.controller;

import com.example.demo.service.CommodityCategoryService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/category")
@Controller
public class CommodityCategoryController {
    @Autowired
    private CommodityCategoryService service;

    /**
     * 查找所有分类
     * @return
     */
    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(service.findAll());
    }
}
