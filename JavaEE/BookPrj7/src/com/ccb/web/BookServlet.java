package com.ccb.web;

import com.ccb.entity.Book;
import com.ccb.entity.Page;
import com.ccb.services.BookServices;
import com.ccb.services.impl.BookServicesImpl;
import com.ccb.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class BookServlet extends BaseServlet {
    BookServices serv = new BookServicesImpl();
    // 列出所有图书请求
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList =  serv.queryForAll();
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
    // 删除功能
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = Integer.parseInt(req.getParameter("id"));
        serv.deleteBookById(i);
        // 用重定向，不然会重复提交表单
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        int v = WebUtils.parseInt(req.getParameter("pageNo"), 0);
        v ++;
        Map<String, String[]> info = req.getParameterMap();
        Book book = WebUtils.MapToBean(info, new Book());
        serv.addBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + v);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = serv.queryById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Book book = WebUtils.MapToBean(req.getParameterMap(), new Book());
        serv.updateBook(book);
        resp.sendRedirect(req.getContextPath() + "/manager/BookServlet?action=page&pageNo=" + req.getParameter("pageNo"));
    }
    // 分页功能
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 10);
        Page page = serv.page(pageNo, pageSize);
        page.setUrl("manager/BookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
