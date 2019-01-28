package com.inofd.utils;

import cn.hutool.db.DbUtil;
import cn.hutool.db.ds.DSFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ResourceBundle;

public class DruidUtils {
    static DataSource ds;

    static{ // 只需要加载一次，所以写成静态代码块。执行本类时，加载
         ds = DSFactory.get();
    }

    public static DataSource getDs() {
        return ds;
    }

    public static Connection getConn() throws SQLException {
        Connection conn = null;
        conn = ds.getConnection();
        return conn;
    }

    // 不建议把conn写为静态的全局变量，然后在方法中关闭
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        DBUtil.close(rs,pstmt,conn);
    }

    public static void close(Statement stmt) {
        DbUtil.close(stmt);
    }

    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
           DbUtil.close(pstmt);
        }
    }

    public void close(ResultSet rs) {
       DbUtil.close(rs);
    }

    public static void commit(Connection conn) {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAutoCommit(Connection conn, boolean autoCommit) {
        if (conn != null) {
            try {
                conn.setAutoCommit(autoCommit);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    //连接测试
    public static void main(String[] args) {
        try {
            if (DruidUtils.getConn()!=null) {
                System.out.println("连接成功！");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}