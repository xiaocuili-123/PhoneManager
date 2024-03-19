package com.baizhi.controller;

import com.baizhi.dao.PhoneDao;
import com.baizhi.dao.impl.PhoneDaoImpl;
import com.baizhi.entity.Phone;
import com.baizhi.service.PhoneService;
import com.baizhi.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/phone/showAllPhone")
public class ShowAllPhoneController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //调用业务层
        PhoneService phoneService = new PhoneServiceImpl();
        List<Phone> phoneList = phoneService.findAllPhone();
        //将查询的结果放入作用域
        req.setAttribute("phoneList",phoneList);
        //跳转
        req.getRequestDispatcher("/showAllPhone.jsp").forward(req,resp);//

    }
}
