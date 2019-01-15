package com.inofd.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.ResourceBundle;

public class DBUtil {
    static ResourceBundle rb;

    static{ // 只需要加载一次，所以写成静态代码块。执行本类时，加载

        try {
            rb = ResourceBundle.getBundle("jdbc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class. forName(rb.getString("jdbc.driver"));
        conn = DriverManager.getConnection(rb.getString("jdbc.url"),
                rb.getString( "jdbc.username"), rb.getString("jdbc.password"));
        return conn;
    }

    // 不建议把conn写为静态的全局变量，然后在方法中关闭
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(Statement stmt) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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


    //连接测试
    public static void main(String[] args) {
        try {
            if (DBUtil.getConn()!=null) {
                System.out.println("连接成功！");

            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}