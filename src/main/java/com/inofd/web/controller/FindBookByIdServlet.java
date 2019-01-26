package com.inofd.web.controller;

import cn.hutool.db.Entity;
import com.inofd.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FindBookByIdServlet",urlPatterns = {"/FindBookByIdServlet"})
public class FindBookByIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        BookServiceImpl bookService = new BookServiceImpl();
        String id = request.getParameter("id");
        List<Entity> bookById = null;
        try {
            bookById = bookService.findBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("books",bookById);
        request.getRequestDispatcher("/admin/products/edit.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request,response);
    }
}
