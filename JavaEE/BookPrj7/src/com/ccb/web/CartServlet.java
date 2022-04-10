package com.ccb.web;


import com.ccb.entity.Book;
import com.ccb.entity.Cart;
import com.ccb.entity.CartItem;
import com.ccb.services.BookServices;
import com.ccb.services.impl.BookServicesImpl;
import com.ccb.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {
    BookServices serv = new BookServicesImpl();
    // 添加商品
    protected  void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = serv.queryById(WebUtils.parseInt(req.getParameter("id"), 0));
        // 判断session中是否有购物车了
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
        }
        CartItem cartItem = new CartItem(book.getId(), book.getBname(), 1, book.getPrice(), book.getPrice());
        cart.addItem(cartItem);
        req.getSession().setAttribute("cart", cart);
        req.getSession().setAttribute("book", cartItem);

        Map<String, Object> json = new HashMap<>();
        json.put("totalCount", cart.getTotalCount());
        json.put("book", cartItem.getName());
        Gson gson = new Gson();
        String jsonStr = gson.toJson(json);
        resp.getWriter().write(jsonStr);
        //resp.sendRedirect(req.getContextPath() + "/index.jsp");
        //resp.sendRedirect(req.getHeader("Referer"));//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    // 删除商品
    protected  void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        cart.deleteItem(id);
        if(cart.isEmpty()){
            req.getSession().invalidate();// 根据前端的session域的购物车为空不显示信息，所以这里需要清空session的cart
        }
        resp.sendRedirect(req.getHeader("referer"));
    }

    // 清空购物车
    protected  void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        req.getSession().invalidate();// 根据前端的session域的购物车为空不显示信息，所以这里需要清空session的cart
        resp.sendRedirect(req.getHeader("referer"));
    }

    // 修改商品数量
    protected  void updateCartItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(req.getParameter("count"), 0);
        cart.updateCartItem(id, count);
        resp.sendRedirect(req.getHeader("referer"));
    }


}
