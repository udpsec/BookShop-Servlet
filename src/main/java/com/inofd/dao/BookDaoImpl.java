package com.inofd.dao;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.db.*;
import com.inofd.domain.Book;
import com.inofd.utils.DbUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl {
    SqlConnRunner runner = null;
    Connection con = null;
    public List<Entity> findAllBook() throws SQLException {
        runner = SqlConnRunner.create(DbUtil.getDs());
        con = new DbUtils().getConnection();
        List<Entity> books = runner.findAll(con,"books");
        return books;
    }
    public List<Entity> findBookById(String id) throws SQLException {
        runner = SqlConnRunner.create(DbUtil.getDs());
        con = new DbUtils().getConnection();
        List<Entity> books = runner.findBy(con,"books","id",id);
        return books;
    }
    public void addBook(Entity book) throws SQLException {
        runner = SqlConnRunner.create(DbUtil.getDs());
        con = new DbUtils().getConnection();
        runner.insert(con,book);
    }
}
