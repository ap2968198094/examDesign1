package com.example.demo.controller;

import com.example.demo.service.CommodityInfoService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.PageVo;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@ResponseBody
@RequestMapping("/commodityInfo")
public class CommodityInfoController {
    @Autowired
    private CommodityInfoService service;

    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(service.findAll());
    }

    @GetMapping("/findPages")
    public ResultVo findCommodityInfoPages(HttpServletRequest request, HttpServletResponse response){
        String currentPageStr = request.getParameter("currentPage");
        int currentPage = 0;//当前页码
        if (currentPageStr != null && currentPageStr.length() > 0 ){
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        PageVo pageVo = service.findCommodityInfoPages(currentPage);
        return ResultVoUtil.success(pageVo);
    }
}
