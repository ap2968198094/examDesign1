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
     * ע�Ṧ��
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
            Boolean flag = userService.regist(user);
            if (flag){

                return ResultVoUtil.success(null);
            }
            return ResultVoUtil.error("�û����Ѵ���");
        } else {
            return ResultVoUtil.error("��֤�����");
        }



    }

    /**
     * �û���¼
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
                request.getSession().setAttribute("user",userService.findByUsername(user.getUsername()));
                System.out.println("��¼�ɹ�");
                return ResultVoUtil.success(null);
            }
            return ResultVoUtil.error("�û������������");
        } else {
            return ResultVoUtil.error("��֤�����");
        }

    }

    /**
     * �û�����
     * @param code
     * @return
     */
    @GetMapping("/active/{code}")
    public String active(@PathVariable("code") String code){
        Boolean flag = userService.active(code);
        if (flag){
            return "����ɹ�����<a href='http://localhost:8181/login.html'>��¼</a>";
        }
        return "����ʧ��";
    }

    /**
     * ���ҵ�ǰ��¼���û���Ϣ
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
     * �û��˳�����
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @GetMapping("/exit")
    public ResultVo exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.����session
        request.getSession().invalidate();

        //2.��ת��¼ҳ��
        response.sendRedirect(request.getContextPath()+"/login.html");
        return ResultVoUtil.success(null);
    }


}
