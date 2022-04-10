package com.ccb.services;

import com.ccb.entity.Book;

import java.util.List;

public interface BookServices {
    void addBook(Book book);
    void deleteBookById(Integer id);
    void updateBook(Book book);
    Book queryById(Integer id);
    List<Book> queryForAll();

}
