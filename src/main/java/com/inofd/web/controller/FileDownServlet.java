package com.inofd.web.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "FileDownServlet",urlPatterns = "/FileDown")
public class FileDownServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filname = "奥力给.txt";
        String path = "D://"+filname;
        filname = URLEncoder.encode(filname,"UTF-8");
        FileInputStream fis = new FileInputStream(path);
        response.setHeader("Content-disposition","attachment;filename="+filname);
        ServletOutputStream sos = response.getOutputStream();

        try {
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fis.read(bytes)) != -1) {
                sos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            } else if (sos != null) {
                sos.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
}
