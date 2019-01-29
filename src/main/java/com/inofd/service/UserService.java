package com.inofd.service;

import cn.hutool.db.Entity;
import com.inofd.dao.UserDao;
import com.inofd.domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();
    public void register(User record){
        try {
            userDao.insert(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Entity> checkUserByName(String username){
        return userDao.selectByUserName(username);
    }
}
