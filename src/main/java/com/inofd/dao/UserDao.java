package com.inofd.dao;

import cn.hutool.db.Entity;
import cn.hutool.db.Session;
import cn.hutool.db.SqlConnRunner;
import cn.hutool.db.ds.DSFactory;
import com.inofd.domain.User;
import com.inofd.utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserDao implements UserMapper {

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(User record) throws SQLException {
        Session session = Session.create();
        try {
            session.beginTransaction();
            session.insert(Entity.parse(record));
            session.commit();
        } catch (SQLException e) {
            session.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertSelective(User record) {
        return 0;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
