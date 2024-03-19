package com.baizhi.controller;

import com.baizhi.service.PhoneService;
import com.baizhi.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/phone/deleteOnePhone")
public class DeleteOnePhoneController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        String phoneIdStr = req.getParameter("phoneId");
        int phoneId = Integer.parseInt(phoneIdStr);

        //调用业务层方法
        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.deleteOnePhone(phoneId);

        //跳转
        resp.sendRedirect(req.getContextPath()+"/phone/showAllPhone");

    }
}
