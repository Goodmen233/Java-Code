package com.ccb.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Dbutils {
    private static DruidDataSource dataSource;
    private static Properties properties = new Properties();
    private static ThreadLocal<Connection> threadConn = new ThreadLocal<>();
    static{
        try {
            InputStream is = Dbutils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            properties.load(is);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取事务属性数据库连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = threadConn.get();
        if(conn == null){
            try {
                conn = dataSource.getConnection();
                conn.setAutoCommit(false);
                threadConn.set(conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    /**
     * 获取数据库连接
     */
    public static Connection getCommonConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 提交事务并关闭连接
     */
    public static void commitAndClose(){
        Connection conn = threadConn.get();
        if(conn != null){
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        threadConn.remove();// 一定要移出，因为Tomcat使用了线程池技术？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
    }

    /**
     * 回滚并关闭事务
     */
    public static void rollbackAndClose(){
        Connection conn = threadConn.get();
        if(conn != null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        threadConn.remove();// 一定要移出，因为Tomcat使用了线程池技术？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void close(Connection conn){
        try {
            if(conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
