package com.ccb.dao.impl;

import com.ccb.dao.BookDao;
import com.ccb.entity.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`bname` , `author` , `price` , `sales` , `stock` , `imgPath`)" +
                "values(? , ? , ? , ? , ? , ?)";
        return update(sql, book.getBname(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set bname=?, author=?, price=?, sales=?, stock=?, imgPath=? where id=?";
        return update(sql, book.getBname(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImgPath(), book.getId());
    }

    @Override
    public Book queryById(Integer id) {
        String sql = "select id, bname, author, price, sales, stock, imgPath from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryForAll() {
        String sql = "select id, bname, author, price, sales, stock, imgPath from t_book";
        return queryForList(Book.class, sql);
    }
}
