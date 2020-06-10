package com.example.demo.controller;

import com.example.demo.entity.CommodityInfo;
import com.example.demo.entity.Favorite;
import com.example.demo.entity.User;
import com.example.demo.repository.CommodityInfoRepository;
import com.example.demo.service.CommodityInfoService;
import com.example.demo.service.FavoriteService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService service;
    @Autowired
    private CommodityInfoRepository repository;

    @GetMapping("/save")
    public void save(HttpServletRequest request){
        int commodityId = Integer.parseInt(request.getParameter("rid"));
        int userId = ((User) request.getSession().getAttribute("user")).getUid();
        Favorite f = new Favorite();
        f.setCommodityId(commodityId);
        f.setUserId(userId);
        service.save(f);
    }

    @GetMapping("/findAll")
    public ResultVo findAll(HttpServletRequest request){
        int id = ((User) request.getSession().getAttribute("user")).getUid();
        List<Favorite> list = service.findAllById(id);
        List<CommodityInfo> li = new ArrayList<>();
        for (Favorite favorite : list) {
            li.add(repository.findById(favorite.getCommodityId()).get());
        }
        return ResultVoUtil.success(li);
    }
}
