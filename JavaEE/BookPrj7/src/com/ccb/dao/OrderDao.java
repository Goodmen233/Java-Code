package com.ccb.dao;

import com.ccb.entity.Order;

import java.util.List;

public interface OrderDao {
    int saveOrder(Order order);
    List<Order> queryOrder();
    void changeStatus(Integer orderId, Integer status);
    List<Order> queryOrderByUserId(Integer userId);
}
