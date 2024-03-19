package com.baizhi.controller;

import com.baizhi.entity.Phone;
import com.baizhi.service.PhoneService;
import com.baizhi.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
@WebServlet("/phone/addPhone")
public class AddPhoneController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        req.setCharacterEncoding("utf-8");
        String phoneName = req.getParameter("phoneName");
        String priceStr = req.getParameter("price");
        String stateStr = req.getParameter("state");
        String brandIdStr = req.getParameter("brandId");
        //将string类型转换为封装对象需要的数据类型
        BigDecimal price = new BigDecimal(priceStr);
        int state = Integer.parseInt(stateStr);
        int brandId = Integer.parseInt(brandIdStr);

        //封装成phone对象
        Phone phone = new Phone(null, phoneName, price, state, brandId, null);
        //调用业务层
        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.addPhone(phone);
         //跳转
        resp.sendRedirect(req.getContextPath()+"/phone/showAllPhone");


    }
}
