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
import java.util.List;

@WebServlet("/brand/showAllBrand")
public class ShowAllBrandController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用业务层
        BrandService brandService = new BrandServiceImpl();
        List<Brand> brandList = brandService.findBrand();
        //将结果放入作用域
        req.setAttribute("brandList",brandList);
        //跳转
        req.getRequestDispatcher("/showAllBrand.jsp").forward(req,resp);
    }
}
