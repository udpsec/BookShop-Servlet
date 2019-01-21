package com.inofd.service;

import com.inofd.dao.UserDao;

public class UserService implements UserDao {
    @Override
    public boolean checkUser(String username, String password) {
        return false;
    }
}
