package com.ccb.test;

import com.ccb.dao.UserDao;
import com.ccb.dao.impl.BaseDao;
import com.ccb.dao.impl.UserDaoImpl;
import com.ccb.entity.User;
import com.ccb.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImplTest {
    @Test
    public void test() throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.queryUser("zhangsan");
        System.out.println(user);
    }
}
