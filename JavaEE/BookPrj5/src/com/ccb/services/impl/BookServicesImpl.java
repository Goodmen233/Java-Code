package com.ccb.services.impl;

import com.ccb.dao.BookDao;
import com.ccb.dao.impl.BookDaoImpl;
import com.ccb.entity.Book;
import com.ccb.services.BookServices;

import java.util.List;

public class BookServicesImpl implements BookServices {
    BookDao dao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        dao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        dao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        dao.updateBook(book);
    }

    @Override
    public Book queryById(Integer id) {
        return dao.queryById(id);
    }

    @Override
    public List<Book> queryForAll() {
        return dao.queryForAll();
    }
}
