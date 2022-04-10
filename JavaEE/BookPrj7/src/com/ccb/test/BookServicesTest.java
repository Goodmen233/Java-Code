package com.ccb.test;

import com.ccb.entity.Book;
import com.ccb.services.BookServices;
import com.ccb.services.impl.BookServicesImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServicesTest {
    BookServices serv = new BookServicesImpl();
    @Test
    public void addBook() {
        Book book = new Book("Java从入门到如图", new BigDecimal(1234), "CCB", 40000, 4000, null);
        serv.addBook(book);
    }

    @Test
    public void updateBook() {
    }

    @Test
    public void queryById() {
    }

    @Test
    public void queryForAll() {
    }

    @Test
    public void deleteBookById(){

    }
}