package com.ccb.test;

import com.ccb.dao.BookDao;
import com.ccb.dao.impl.BookDaoImpl;
import com.ccb.entity.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    BookDao dao = new BookDaoImpl();
    @Test
    public void addBook() {
        Book book = new Book("Java从入门到如图", new BigDecimal(1234), "CCB", 40000, 4000, null);
        dao.addBook(book);
    }

    @Test
    public void deleteBookById() {
        System.out.println(dao.deleteBookById(21));
    }

    @Test
    public void updateBook() {
        Book book = new Book(21,"Javafrom", new BigDecimal(9999), "CCB", 9000, 900, "static/img/haha.jpg");
        dao.updateBook(book);
    }

    @Test
    public void queryById() {
        System.out.println(dao.queryById(21));
    }

    @Test
    public void queryForAll() {
        List<Book> list = dao.queryForAll();
        System.out.println(list);
    }
}