package com.inofd.web.controller;

import cn.hutool.db.Entity;
import com.inofd.domain.Books;
import com.inofd.service.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AddBookServlet",urlPatterns = {"/AddBookServlet"})
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Books books = new Books();
        try {
            BeanUtils.populate(books,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        BookServiceImpl bookService = new BookServiceImpl();
        bookService.addBook(books);
        List<Entity> allBooks = null;
        try {
            allBooks = bookService.findAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("book",allBooks);
        request.getRequestDispatcher("/admin/products/list.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
