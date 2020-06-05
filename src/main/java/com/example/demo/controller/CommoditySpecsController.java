package com.example.demo.controller;

import com.example.demo.service.CommoditySpecsService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commoditySpecs")
@ResponseBody
public class CommoditySpecsController {
    @Autowired
    private CommoditySpecsService commoditySpecsService;

    /**
     * 查找商品所有规格
     * @return
     */
    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(commoditySpecsService.findAll());
    }
}
