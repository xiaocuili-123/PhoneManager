package com.baizhi.controller;

import com.baizhi.entity.Brand;
import com.baizhi.service.BrandService;
import com.baizhi.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/brand/addBrand")
public class AddBrandController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //收参
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("brandName");
        //封装成brand对象
        Brand brand = new Brand(null, name, null);
        //调用业务层方法
        BrandService brandService = new BrandServiceImpl();
        brandService.insertBrand(brand);
        //跳转
        resp.sendRedirect(req.getContextPath()+"/brand/showAllBrand");
    }
}
