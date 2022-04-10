package com.ccb.test;

import com.ccb.dao.OrderDao;
import com.ccb.dao.impl.OrderDaoImpl;
import com.ccb.entity.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao dao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        Order order = new Order("90897977868", new Date(), new BigDecimal(18.00), 0, 1);
        dao.saveOrder(order);
    }

    @Test
    public void queryOrder() {
    }

    @Test
    public void changeStatus() {
    }

    @Test
    public void queryOrderByUserId() {
    }
}