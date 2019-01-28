package com.inofd.web.controller;

import cn.hutool.core.lang.Validator;
import com.inofd.domain.User;
import com.inofd.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        User user = new User();
        UserService userService = new UserService();
        Map<String, String[]> map = request.getParameterMap();
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean email1 = Validator.isEmail(username);

        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        userService.register(user);
        request.getRequestDispatcher("registersuccess.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
