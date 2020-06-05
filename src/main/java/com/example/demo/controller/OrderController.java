package com.example.demo.controller;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.entity.CommodityOrder;
import com.example.demo.service.OrderService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @GetMapping("/save")
    public ResultVo save(HttpServletRequest request){
        List<CommodityInfo> cart = (List<CommodityInfo>)request.getSession().getAttribute("cart");
        Double s = 0.00;
        for (CommodityInfo commodityInfo : cart) {
            s +=Double.parseDouble(commodityInfo.getCommodityPrice());
            System.out.println(Double.parseDouble(commodityInfo.getCommodityPrice()));
        }
        CommodityOrder order = new CommodityOrder();
        order.setOrderPrice(String.valueOf(s));
        service.save(order);
        return ResultVoUtil.success(order);
    }

    @GetMapping("/status")
    public void status(HttpServletRequest request){
        int orderId = Integer.parseInt(request.getParameter("orderId")) ;
        CommodityOrder order = service.findById(orderId);
        order.setOrderStatus("Y");
        service.save(order);
    }


}