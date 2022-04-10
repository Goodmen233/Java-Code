package com.ccb.services.impl;

import com.ccb.dao.BookDao;
import com.ccb.dao.impl.BookDaoImpl;
import com.ccb.entity.Book;
import com.ccb.entity.Page;
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

    @Override
    public Page page(Integer pageNo, Integer pageSize) {
        Page<Book> page = new Page();
        Integer pageTotalCount = dao.queryForPageTotalCount();// 获取总记录数
        Integer pageTotal = (pageTotalCount%pageSize == 0) ? pageTotalCount/pageSize : pageTotalCount/pageSize + 1;// 获取分页数
        if(pageNo<1) pageNo = 1;
        if(pageNo>pageTotal) pageNo=pageTotal;// 有效性认证
        Integer begin = (pageNo - 1) * pageSize;
        List<Book> items = dao.queryForItems(begin,pageSize);// 获取记录的信息
        page.setItems(items);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return page;
    }

    @Override
    public Page pageByPrice(Integer pageNo, Integer pageSize, Integer min, Integer max) {
        Page<Book> page = new Page();
        Integer pageTotalCount = dao.queryForPageTotalCountByPrice(min, max);// 获取总记录数
        Integer pageTotal = (pageTotalCount%pageSize == 0) ? pageTotalCount/pageSize : pageTotalCount/pageSize + 1;// 获取分页数
        if(pageNo<1) pageNo = 1;
        if(pageNo>pageTotal) pageNo=pageTotal;// 有效性认证
        Integer begin = (pageNo - 1) * pageSize;
        List<Book> items = dao.queryForItemsByPrice(begin,pageSize,min,max);// 获取记录的信息

        page.setItems(items);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(pageTotalCount);
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        return page;
    }
}
