package com.inofd.web.controller;

import cn.hutool.db.Entity;
import cn.hutool.db.handler.BeanListHandler;
import com.inofd.domain.Book;
import com.inofd.service.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "BooksListServlet",urlPatterns = "/findAll")
public class BooksListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookServiceImpl bookService = new BookServiceImpl();
        try {
            List<Entity> book = bookService.findAll();
            if (book != null) {
                request.setAttribute("book",book);
                request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
