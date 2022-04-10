package com.ccb.services;

import com.ccb.entity.Cart;
import com.ccb.entity.Order;

import java.util.List;

public interface OrderServices {
    String createOrder(Cart cart, Integer userId);
    List<Order> showAllOrders();
    void sendOrder(Integer orderId);
    List<Order> showOrderDetail(Integer orderId);
    List<Order> showMyOrders(Integer userId);
    void receiverOrder(Integer orderId);
}
