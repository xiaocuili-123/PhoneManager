package com.baizhi.controller;

import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/user/register")
public class RegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.收参
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        //2.调用业务层
        UserService userService = new UserServiceImpl();
        boolean register=userService.register(username,password1,password2);
        //3.根据结果跳转
        if (register){
            //如果注册成功，重定向到登录页面
            resp.sendRedirect("/PhoneManager/login.jsp");
        }else{
            //如果不成功，重定向到注册页面
            resp.sendRedirect("/PhoneManager/register.jsp");
        }
    }
}


