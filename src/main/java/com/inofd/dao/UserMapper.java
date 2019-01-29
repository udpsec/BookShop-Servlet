package com.inofd.dao;

import cn.hutool.db.Entity;
import com.inofd.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record) throws SQLException;

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    List<Entity> selectByUserName(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}