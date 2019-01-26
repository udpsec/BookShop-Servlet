package com.inofd.service;

import cn.hutool.db.Entity;
import com.inofd.dao.BookDaoImpl;
import com.inofd.domain.Books;

import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl  {
    BookDaoImpl bookDao = new BookDaoImpl();
    public List<Entity> findAllBooks() throws SQLException {
        return bookDao.findAllBooks();
    }
    public void addBook(Books book) throws SQLException {
        bookDao.addBook(book);
    }
}
