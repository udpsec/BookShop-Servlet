package com.inofd.dao;

import cn.hutool.db.*;
import cn.hutool.db.ds.DSFactory;
import com.inofd.domain.Books;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl {
    private  static  SqlConnRunner runner = null;
    private  static Connection con = null;
    static {
        try {
            DataSource ds = DSFactory.get();
            runner = SqlConnRunner.create(ds);
            con = ds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Entity> findAllBooks() throws SQLException {
        List<Entity> books = runner.findAll(con,"books");
        return books;
    }
    public List<Entity> findBookById(String id) throws SQLException {
        List<Entity> books = runner.findBy(con,"books","id",id);
        return books;
    }
    public void addBook(Books book) throws SQLException {
        runner.insert(con, Entity.parse(book));
    }
    public void delBook(String id){
        try {
            runner.del(con, Entity.create("books").set("id",id));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
