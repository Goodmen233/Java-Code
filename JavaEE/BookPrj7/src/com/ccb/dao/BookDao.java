package com.ccb.dao;

import com.ccb.entity.Book;

import java.util.List;

public interface BookDao {
    // 增删改查
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryById(Integer id);
    public List<Book> queryForAll();
    Integer queryForPageTotalCount();
    List<Book> queryForItems(Integer begin, Integer pageSize);
    List<Book> queryForItemsByPrice(Integer begin, Integer pageSize, Integer min, Integer max);
    Integer queryForPageTotalCountByPrice(Integer min, Integer max);
}
