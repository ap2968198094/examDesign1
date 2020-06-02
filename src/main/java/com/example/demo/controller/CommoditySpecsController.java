package com.example.demo.controller;

import com.example.demo.service.CommoditySpecsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("commoditySpecs")
@ResponseBody
public class CommoditySpecsController {
    @Autowired
    private CommoditySpecsService commoditySpecsService;
}
