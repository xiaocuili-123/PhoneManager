package com.baizhi.controller;

import com.baizhi.entity.Brand;
import com.baizhi.entity.Phone;
import com.baizhi.service.BrandService;
import com.baizhi.service.PhoneService;
import com.baizhi.service.impl.BrandServiceImpl;
import com.baizhi.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phone/findOnePhone")
public class FindOnePhoneController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        String phoneIdStr = req.getParameter("phoneId");
        int phoneId = Integer.parseInt(phoneIdStr);
        //调用业务层
        PhoneService phoneService = new PhoneServiceImpl();
        Phone phone = phoneService.findPhoneById(phoneId);
        BrandService brandService = new BrandServiceImpl();
        List<Brand> brandList = brandService.findBrand();//todo
        //放入作用域
        req.setAttribute("phone",phone);
        req.setAttribute("brandList",brandList);
        //跳转
        req.getRequestDispatcher("/updatephone.jsp").forward(req,resp);
    }
}
