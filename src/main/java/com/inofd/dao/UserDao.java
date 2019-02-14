package com.inofd.dao;

import cn.hutool.db.Entity;
import cn.hutool.db.Session;
import com.inofd.domain.User;

import java.sql.SQLException;
import java.util.List;

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
    public List<Entity> selectByUserName(String username) {
        Session session = Session.create();
        List<Entity> by = null;
        try {
            session.beginTransaction();
            by = session.findBy("user", "username", username);
            session.commit();
            return by;
        } catch (SQLException e) {
            try {
                session.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(String activicode) {
        Session session = Session.create();
        List<Entity> by = null;
        try {
            session.beginTransaction();
            session.insertOrUpdate(Entity.create("user"),record.getActivecode());
            session.commit();
        } catch (SQLException e) {
            try {
                session.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
}
