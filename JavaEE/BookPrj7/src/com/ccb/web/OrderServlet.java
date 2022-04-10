package com.ccb.web;

import com.ccb.entity.Cart;
import com.ccb.entity.Order;
import com.ccb.entity.User;
import com.ccb.services.OrderServices;
import com.ccb.services.impl.OrderServicesImpl;
import com.ccb.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderServlet extends BaseServlet {
    OrderServices serv = new OrderServicesImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Integer userId = user.getId();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        String orderId = serv.createOrder(cart, userId);
        req.setAttribute("orderId", orderId);
        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
    }
    protected void showMyOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Order> orderList = serv.showMyOrders(user.getId());
        req.setAttribute("orderList", orderList);
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
    }
}
