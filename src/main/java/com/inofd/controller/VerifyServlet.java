package com.inofd.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

import javax.imageio.ImageIO;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "VerifyServlet", urlPatterns = {"/verifyServlet"})
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.addIntHeader("Expires", -1);
        response.setHeader("Control-Cache", "no-cache");
        response.setHeader("Program", "no-cache");
        response.setContentType("image/jpg");
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(100,10,5,120);
        BufferedImage image = lineCaptcha.getImage();
        ServletOutputStream sos = response.getOutputStream();
        lineCaptcha.write(sos);
        sos.flush();
        sos.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
