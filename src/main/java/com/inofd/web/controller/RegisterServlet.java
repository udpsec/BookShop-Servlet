package com.inofd.web.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.db.Entity;
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
            BeanUtils.populate(user, map);
            Set<ConstraintViolation<User>> validate = validator.validate(user);
            String scode = request.getSession().getAttribute("code").toString();
            String code = request.getParameter("code");
            List<Entity> i = userService.checkUserByName(user.getUsername());
            if (!i.isEmpty()){
                request.setAttribute("checkname", "用户名已存在");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            if (!scode.equalsIgnoreCase(code)) {
                request.setAttribute("errorcode", "验证码错误");
                request.getRequestDispatcher("register.jsp").forward(request, response);
                return;
            }
            if (validate.isEmpty()) {
                user.setActivecode(UUID.fastUUID().toString());
                user.setRole("普通用户");
                userService.register(user);
                request.getRequestDispatcher("registersuccess.jsp").forward(request, response);
            } else {
                for (ConstraintViolation<User> userConstraintViolation : validate) {

                    String message = userConstraintViolation.getMessage();

                    request.setAttribute("error", message);

                    request.getRequestDispatcher("register.jsp").forward(request, response);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
