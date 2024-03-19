package com.baizhi.controller;

import com.baizhi.service.PhoneService;
import com.baizhi.service.impl.PhoneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/phone/deletePhones")
public class DeletePhonesController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String[] ids = req.getParameterValues("ids");

        //
        PhoneService phoneService = new PhoneServiceImpl();
        for (String idStr :
                ids) {
            int id = Integer.parseInt(idStr);
            phoneService.deleteOnePhone(id);
        }

        //跳转
        resp.sendRedirect(req.getContextPath()+"/phone/showAllPhone");
    }
}
