package com.example.demo.controller;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.service.CommodityInfoService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.PageVo;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/commodityInfo")
public class CommodityInfoController {
    @Autowired
    private CommodityInfoService service;

    /**
     * 查找所有商品信息
     * @return
     */
    @GetMapping("/findAll")
    public ResultVo findAll(){
        return ResultVoUtil.success(service.findAll());
    }

    /**
     * 查找分页结果集
     * @param request
     * @param response
     * @return
     */
    @GetMapping("/findPages")
    public ResultVo findCommodityInfoPages(HttpServletRequest request, HttpServletResponse response){
        String currentPageStr = request.getParameter("currentPage");
        String cidStr = request.getParameter("cid");
        int currentPage = 0;//当前页码
        if (currentPageStr != null && currentPageStr.length() > 0 ){
            currentPage = Integer.parseInt(currentPageStr);
        } else {
            currentPage = 1;
        }
        int cid = 0;
        if (cidStr != null && cidStr.length() > 0) {
            cid = Integer.parseInt(cidStr);
        }else {
            cid = 0;
        }
        PageVo pageVo = service.findCommodityInfoPages(cid,currentPage);
        return ResultVoUtil.success(pageVo);
    }

    /**
     * 根据商品id查找商品
     * @param request
     * @return
     */
    @GetMapping("/findOne")
    public ResultVo findOne(HttpServletRequest request){
        String rid = request.getParameter("rid");
        return ResultVoUtil.success(service.findById(rid));
    }

    /**
     * 加入购物车
     * @param request
     * @return
     */
    @GetMapping("/addCart")
    public ResultVo addCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        List<CommodityInfo> cart = null;
        if (session.getAttribute("cart") != null){
            cart = (List<CommodityInfo>)session.getAttribute("cart");
        }else {
            cart = new ArrayList<>();
        }
        String rid = request.getParameter("rid");
        cart.add(service.findById(rid));
        session.setAttribute("cart",cart);
        System.out.println(cart);
        return ResultVoUtil.success(null);

    }

    /**
     * 返回购物车集合
     * @param request
     * @return
     */
    @GetMapping("/findCart")
    public ResultVo findCart(HttpServletRequest request){
        List<CommodityInfo> cart = (List<CommodityInfo>)request.getSession().getAttribute("cart");
        return ResultVoUtil.success(cart);
    }

    @GetMapping("/search")
    public ResultVo search(HttpServletRequest request){
        String name = request.getParameter("name");
        List<CommodityInfo> list = service.findByCommodityNameLike("%" + name + "%");
        return ResultVoUtil.success(list);
    }
}
