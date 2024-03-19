package com.baizhi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/validateCode")
public class ValidateCodeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
            //1,生成内容变化的验证码图片
            LineCaptcha captcha = CaptchaUtil.createLineCaptcha(120, 50);
            //2,将图片实际内容保存到session中
                //获取图片的实际内容
            String code = captcha.getCode();
            //获取session
            HttpSession session = req.getSession();
            //将实际内容保存到session中
            session.setAttribute("realCode",code);
            //3,将图片输出到页面中
            ServletOutputStream stream = resp.getOutputStream();
            captcha.write(stream);
        }
    }
