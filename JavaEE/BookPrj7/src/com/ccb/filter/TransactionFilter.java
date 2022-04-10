package com.ccb.filter;

import com.ccb.utils.Dbutils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransactionFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try{
            chain.doFilter(request, response);
            Dbutils.commitAndClose();
        }catch (Exception e){
            Dbutils.rollbackAndClose();
            throw new RuntimeException(e);
        }
    }
}
