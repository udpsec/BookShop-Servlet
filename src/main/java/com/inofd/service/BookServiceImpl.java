package com.inofd.service;

import cn.hutool.db.Entity;
import com.inofd.dao.BookDaoImpl;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl {
    BookDaoImpl bookDao = new BookDaoImpl();
    public List<Entity> findAll() throws SQLException {
        List<Entity> all = bookDao.findAllBook();
        return all;
    }
    public List<Entity> findBookById(String id) throws SQLException {
        List<Entity> books = bookDao.findBookById(id);
        return books;
    }
    public void addBook(Entity book) throws SQLException {
        bookDao.addBook(book);
    }
    @Test
    public void findBookById1() throws SQLException {
        List<Entity> books = bookDao.findBookById("1001");
        for (Entity book : books) {
            System.out.println(book.getStr("name"));
        }
    }
}
