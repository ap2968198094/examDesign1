package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ResultVoUtil;
import com.example.demo.vo.ResultVo;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/regist")
    public ResultVo registe(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        //1.获取数据
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("CHECKCODE_SERVER"));

        Map<String, String[]> map = request.getParameterMap();
        System.out.println(request.getParameter("check"));

        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Boolean flag = userService.regist(user);
        if (flag){
            return ResultVoUtil.success(null);
        }
        return ResultVoUtil.error("注册失败");

    }

    @GetMapping("/login")
    public ResultVo login(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        //1.获取数据
        Map<String, String[]> map = request.getParameterMap();

        //2.封装对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Boolean flag = userService.login(user);
        if (flag){
            System.out.println("登录成功");
            return ResultVoUtil.success(null);
        }
        return ResultVoUtil.error("注册失败");

    }

    @GetMapping("/active/{code}")
    public String active(@PathVariable("code") String code){
        Boolean flag = userService.active(code);
        if (flag){
            return "激活成功，请<a href='http://localhost:8181/login.html'>登录</a>";
        }
        return "激活失败";
    }



}
