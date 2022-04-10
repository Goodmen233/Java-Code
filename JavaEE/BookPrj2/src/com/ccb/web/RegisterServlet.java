package com.ccb.web;

import com.ccb.entity.User;
import com.ccb.services.UserServices;
import com.ccb.services.impl.UserServicesImpl;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class RegisterServlet extends HttpServlet {
    private UserServices userServices= new UserServicesImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1、获取请求参数
         * 2、检查验证码，正确继续，错误重新注册页面
         * 3、检查用户名是否可用，可用调用SaveUser保存并跳到注册成功页面，否则跳回注册页面
         */
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if("abcd".equalsIgnoreCase(code)){
            if(userServices.isExitUser(username)){
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            }else{
                System.out.println("注册成功");
                userServices.register(new User(username, password, email));
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req, resp);
            }
        }else{
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
        }

    }
}
