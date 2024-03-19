package com.baizhi.controller;

import com.baizhi.dao.BrandDao;
import com.baizhi.dao.impl.BrandDaoImpl;
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
@WebServlet("/brand/findAllBrand")
public class FindAllBrandController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BrandService brandService = new BrandServiceImpl();
        List<Brand> brandlist = brandService.findBrand();

        //将查询结果放入作用域
        req.setAttribute("brandList",brandlist);//“数据名”，数据值

        //跳转
        req.getRequestDispatcher("/addPhone.jsp").forward(req,resp);


    }
}
