package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        //设置解码集格式
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //获取验证码
        String validateCode = req.getParameter("validateCode");
        //获取session中的验证码
        HttpSession session = req.getSession();
        String realCode = (String) session.getAttribute("realCode");
        //比较验证码
        if (validateCode!=null&&!validateCode.equalsIgnoreCase(realCode)) {
            //比对不成功
            resp.sendRedirect("/PhoneManager/login.jsp");
            return;
        }
        //调用业务层
        UserService userService = new UserServiceImpl();
        User user = userService.login(username,password);
        //根据结果跳转
        if (user!=null) {

//            Cookie cookie = new Cookie("username",username);
//            resp.addCookie(cookie);
            HttpSession session1 = req.getSession();
            session1.setAttribute("login",user);

            //ToDo
            //重定向到查询所有手机控制器
            resp.sendRedirect(req.getContextPath()+"/phone/showAllPhone");//展示所有手机控制器
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }
}
