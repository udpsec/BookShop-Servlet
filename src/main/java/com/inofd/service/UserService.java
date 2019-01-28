package com.inofd.service;

import com.inofd.dao.UserDao;
import com.inofd.domain.User;

import java.sql.SQLException;

public class UserService {
    public void register(User record){
        UserDao userDao = new UserDao();
        try {
            userDao.insert(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
