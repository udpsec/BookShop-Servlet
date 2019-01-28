package com.inofd.dao;

import com.inofd.domain.User;

import java.sql.SQLException;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record) throws SQLException;

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}