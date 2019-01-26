package com.inofd.service;

import cn.hutool.db.Entity;
import com.inofd.dao.BookDaoImpl;
import com.inofd.domain.Books;

import java.awt.print.Book;
import java.sql.SQLException;
import java.util.List;

public class BookServiceImpl  {
    BookDaoImpl bookDao = new BookDaoImpl();
    public List<Entity> findAllBooks() throws SQLException {
        return bookDao.findAllBooks();
    }
    public void addBook(Books book) {
        try {
            bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Entity> findBookById(String id) throws SQLException {
        return bookDao.findBookById(id);
    }
    public void delBook(String id){
        bookDao.delBook(id);
    }
}
