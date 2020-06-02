package com.example.demo.controller;

import com.example.demo.service.CommodityInfoService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/commodity")
public class CommodityInfoController {
    @Autowired
    private CommodityInfoService service;

    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(service.findAll());
    }
}
