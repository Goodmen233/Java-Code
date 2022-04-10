package com.ccb.dao.impl;

import com.ccb.utils.Dbutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner runner = new QueryRunner();

    /**
     * 增删改数据库中的数据
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql, Object...args){
        Connection conn = Dbutils.getConnection();
        try {
            return runner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询单个数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object...args){
        Connection conn = Dbutils.getConnection();
        try {
            return runner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询多个数据
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args){
        Connection conn = Dbutils.getConnection();
        try {
            return runner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 执行返回一行一列的数据
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSpecial(String sql, Object...args){
        Connection conn = Dbutils.getConnection();
        try {
            return runner.query(conn, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
