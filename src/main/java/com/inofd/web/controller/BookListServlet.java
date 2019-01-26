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

@WebServlet(name = "BookListServlet",urlPatterns = {"/findAll"})
public class BookListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        BookServiceImpl bookService = new BookServiceImpl();
        try {
            List<Entity> allBooks = bookService.findAllBooks();
            if (allBooks != null) {
                request.setAttribute("book",allBooks);
                request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
