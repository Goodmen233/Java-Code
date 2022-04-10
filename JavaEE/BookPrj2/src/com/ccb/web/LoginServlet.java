package com.ccb.web;

import com.ccb.entity.User;
import com.ccb.services.UserServices;
import com.ccb.services.impl.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserServices userServices = new UserServicesImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1、获取请求参数
         * 2、new user
         * 3、调用方法查看，有跳转login_sucess,，反之重新登录
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username, password, null);
        User reUser = userServices.login(user);
        if(reUser != null){
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }else{
            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        }
    }
}
