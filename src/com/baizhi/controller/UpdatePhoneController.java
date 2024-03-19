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

@WebServlet("/phone/updatePhone")
public class UpdatePhoneController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String phoneIdStr = req.getParameter("phoneId");
        String phoneName = req.getParameter("phoneName");
        String stateStr = req.getParameter("state");
        String priceStr = req.getParameter("price");
        String brandIdStr = req.getParameter("brandId");

        int phoneId = Integer.parseInt(phoneIdStr);
        int state = Integer.parseInt(stateStr);
        BigDecimal price = new BigDecimal(priceStr);
        int brandId = Integer.parseInt(brandIdStr);

        Phone phone = new Phone(phoneId,phoneName,price,state,brandId,null);

        PhoneService phoneService = new PhoneServiceImpl();
        phoneService.updatePhone(phone);

        resp.sendRedirect(req.getContextPath()+"/phone/showAllPhone");
    }
}
