package com.ccb.dao.impl;

import com.ccb.dao.OrderDao;
import com.ccb.entity.Order;
import com.ccb.web.BaseServlet;

import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(orderId, createTime, price, status, userId) values(?,?,?,?,?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryOrder() {
        String sql = "select orderId, createTime, price, status, userId from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public void changeStatus(Integer orderId, Integer status) {
        String sql = "update t_order set status=? where orderId=?";
        update(sql, status, orderId);
    }

    @Override
    public List<Order> queryOrderByUserId(Integer userId) {
        String sql = "select orderId, createTime, price, status, userId from t_order where userId=?";
        return queryForList(Order.class, sql, userId);
    }
}
