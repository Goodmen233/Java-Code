package com.ccb.dao;

import com.ccb.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int saveOrderItem(OrderItem item);
    List<OrderItem> queryOrderItemByOrderId(Integer orderid);
}
