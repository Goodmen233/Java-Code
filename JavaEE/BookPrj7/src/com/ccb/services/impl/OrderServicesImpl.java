package com.ccb.services.impl;

import com.ccb.dao.BookDao;
import com.ccb.dao.OrderDao;
import com.ccb.dao.OrderItemDao;
import com.ccb.dao.impl.BookDaoImpl;
import com.ccb.dao.impl.OrderDaoImpl;
import com.ccb.dao.impl.OrderItemDaoImpl;
import com.ccb.entity.*;
import com.ccb.services.OrderServices;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServicesImpl implements OrderServices {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao oItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 存储订单信息
        String orderId = System.currentTimeMillis() + "" + userId;
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        int i = 12/0;

        // 存储订单项
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            CartItem item = entry.getValue();
            OrderItem orderItem = new OrderItem(null, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), orderId);
            oItemDao.saveOrderItem(orderItem);
            // 更新库存和销量
            Book book = bookDao.queryById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> showAllOrders() {
        return null;
    }

    @Override
    public void sendOrder(Integer orderId) {

    }

    @Override
    public List<Order> showOrderDetail(Integer orderId) {
        return null;
    }

    @Override
    public List<Order> showMyOrders(Integer userId) {
        return orderDao.queryOrderByUserId(userId);
    }

    @Override
    public void receiverOrder(Integer orderId) {

    }
}
