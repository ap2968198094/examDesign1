package com.example.demo.controller;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.entity.CommodityOrder;
import com.example.demo.entity.User;
import com.example.demo.service.CommodityInfoService;
import com.example.demo.service.OrderService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @Autowired
    private CommodityInfoService commodityInfoService;

    /**
     * 从购物车到数据并创建订单
     * @param request
     * @return
     */
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
        order.setUserId(((User)request.getSession().getAttribute("user")).getUid());
        service.save(order);
        HttpSession session = request.getSession();
        session.setAttribute("cartEnd",session.getAttribute("cart"));
        request.getSession().removeAttribute("cart");
        return ResultVoUtil.success(order);
    }

    /**
     * 改变订单的支付状态
     * @param request
     */
    @GetMapping("/status")
    public void status(HttpServletRequest request){
        int orderId = Integer.parseInt(request.getParameter("orderId")) ;
        List<CommodityInfo> list = (List<CommodityInfo>)request.getSession().getAttribute("cartEnd");
        for (CommodityInfo commodityInfo : list) {
            commodityInfo.setCommodityStock(commodityInfo.getCommodityStock()-1);
            commodityInfoService.save(commodityInfo);
        }
        CommodityOrder order = service.findById(orderId);
        order.setOrderStatus("Y");
        service.save(order);
    }

    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(service.findAll());
    }


}
