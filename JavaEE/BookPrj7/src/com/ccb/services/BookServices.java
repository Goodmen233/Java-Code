package com.ccb.services;

import com.ccb.entity.Book;
import com.ccb.entity.Page;

import java.util.List;

public interface BookServices {
    void addBook(Book book);
    void deleteBookById(Integer id);
    void updateBook(Book book);
    Book queryById(Integer id);
    List<Book> queryForAll();
    Page page(Integer pageNo, Integer pageSize);
    Page pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max);
}
