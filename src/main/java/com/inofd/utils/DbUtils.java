package com.inofd.utils;

import cn.hutool.db.Db;
import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.DSFactory;
import cn.hutool.db.ds.pooled.DbSetting;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbUtils {
    public Connection getConnection() throws SQLException {
        DataSource ds = DSFactory.get();
        Connection connection = ds.getConnection();
        return connection;
    }
}
