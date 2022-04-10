package com.ccb.dao.impl;

import com.ccb.dao.OrderItemDao;
import com.ccb.entity.OrderItem;

import java.util.List;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem item) {
        String sql = "insert into t_order_item (name, count, price, totalPrice, orderId) values(?,?,?,?,?)";
        return update(sql, item.getName(), item.getCount(), item.getPrice(), item.getTotalPrice(), item.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(Integer orderid) {
        String sql = "select id, name, count, price, totalPrice, orderId from t_order_item where orderId=?";
        return queryForList(OrderItem.class, sql, orderid);
    }
}
