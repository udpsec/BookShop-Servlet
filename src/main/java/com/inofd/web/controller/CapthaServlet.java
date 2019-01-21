package com.inofd.web.controller;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CapthaServlet", urlPatterns = "/CapthaServlet")
public class CapthaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 120;
        int height = 30;
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
        graphics.setColor(Color.gray);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.blue);
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);

            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }
        int left = 5;
        graphics.setColor(Color.yellow);
        for (int i = 0; i < 4; i++) {
            int r = random.nextInt(10);
            graphics.drawString(r + "", left + i * 20, 20);
        }
        response.setContentType("image/jpeg");
        ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
