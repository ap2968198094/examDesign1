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
        //1.��ȡ����
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("CHECKCODE_SERVER"));

        Map<String, String[]> map = request.getParameterMap();
        System.out.println(request.getParameter("check"));

        //2.��װ����
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
        return ResultVoUtil.error("ע��ʧ��");

    }

    @GetMapping("/login")
    public ResultVo login(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        //1.��ȡ����
        Map<String, String[]> map = request.getParameterMap();

        //2.��װ����
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
            System.out.println("��¼�ɹ�");
            return ResultVoUtil.success(null);
        }
        return ResultVoUtil.error("ע��ʧ��");

    }

    @GetMapping("/active/{code}")
    public String active(@PathVariable("code") String code){
        Boolean flag = userService.active(code);
        if (flag){
            return "����ɹ�����<a href='http://localhost:8181/login.html'>��¼</a>";
        }
        return "����ʧ��";
    }



}
