package com.ccb.test;

import com.ccb.utils.Dbutils;
import org.junit.Test;

import java.sql.Connection;

public class JDBCTest {
    @Test
    public void getConn(){
        Connection conn = Dbutils.getConnection();
        System.out.println(conn);
        Dbutils.close(conn);
    }
}


