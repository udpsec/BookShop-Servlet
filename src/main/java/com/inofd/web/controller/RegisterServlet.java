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
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        User user = new User();
        UserService userService = new UserService();
        Map<String, String[]> map = request.getParameterMap();
        ArrayList<String> error = new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        try {
            BeanUtils.populate(user,map);
            Set<ConstraintViolation<User>> validate = validator.validate(user);
            if (validate.isEmpty()) {
                userService.register(user);
                request.getRequestDispatcher("registersuccess.jsp").forward(request,response);
            }else {
                for (ConstraintViolation<User> userConstraintViolation : validate) {
                    String message = userConstraintViolation.getMessage();
                    request.setAttribute("error",message);
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }
            }

 /*           boolean email = Validator.isEmail(user.getEmail());
            boolean username = Validator.isGeneral(user.getUsername(),6,12);
            boolean password = Validator.isGeneral(user.getPassword(),6,12);
            boolean repassword = Validator.equal(user.getPassword(),request.getParameter("repassword").toString());
            if (email) {
                userService.register(user);
                request.getRequestDispatcher("registersuccess.jsp").forward(request,response);
            }else {
                response.getWriter().write("不是邮箱");

            }*/

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
