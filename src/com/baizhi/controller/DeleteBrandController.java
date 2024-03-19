package com.baizhi.controller;

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

@WebServlet("/brand/deleteBrand")
public class DeleteBrandController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandIdStr = req.getParameter("brandId");
        int brandId = Integer.parseInt(brandIdStr);

        PhoneService phoneService = new PhoneServiceImpl();
        BrandService brandService = new BrandServiceImpl();
        phoneService.deleteByBrandId(brandId);
        brandService.deleteBrandById(brandId);

        resp.sendRedirect(req.getContextPath()+"/brand/showAllBrand");
    }
}
