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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册功能
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/regist")
    public ResultVo registe(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");

        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("check");
        if (check.equalsIgnoreCase(checkcode_server)){
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
            Boolean flag = userService.regist(user);
            if (flag){

                return ResultVoUtil.success(null);
            }
            return ResultVoUtil.error("用户名已存在");
        } else {
            return ResultVoUtil.error("验证码错误");
        }



    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @return
     */
    @PostMapping("/login")
    public ResultVo login(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String checkcode_server = (String)session.getAttribute("CHECKCODE_SERVER");
        String check = request.getParameter("check");
        if (check.equalsIgnoreCase(checkcode_server)){
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
                request.getSession().setAttribute("user",userService.findByUsername(user.getUsername()));
                System.out.println("登录成功");
                return ResultVoUtil.success(null);
            }
            return ResultVoUtil.error("用户名或密码错误");
        } else {
            return ResultVoUtil.error("验证码错误");
        }

    }

    /**
     * 用户激活
     * @param code
     * @return
     */
    @GetMapping("/active/{code}")
    public String active(@PathVariable("code") String code){
        Boolean flag = userService.active(code);
        if (flag){
            return "激活成功，请<a href='http://localhost:8181/login.html'>登录</a>";
        }
        return "激活失败";
    }

    /**
     * 查找当前登录的用户信息
     * @param request
     * @return
     */
    @GetMapping("/findOne")
    public ResultVo findOne(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            return ResultVoUtil.success(null);
        }
        return ResultVoUtil.success(user);
    }

    /**
     * 用户退出功能
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/exit")
    public ResultVo exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.销毁session
        request.getSession().invalidate();

        //2.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");
        return ResultVoUtil.success(null);
    }


}
