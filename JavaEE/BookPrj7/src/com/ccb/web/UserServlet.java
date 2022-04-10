package com.ccb.web;

import com.ccb.entity.User;
import com.ccb.services.UserServices;
import com.ccb.services.impl.UserServicesImpl;
import com.ccb.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class UserServlet extends BaseServlet {
    private UserServices userServices= new UserServicesImpl();
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        /**
         * 1、获取请求参数
         * 2、检查验证码，正确继续，错误重新注册页面
         * 3、检查用户名是否可用，可用调用SaveUser保存并跳到注册成功页面，否则跳回注册页面
         */
        User user = WebUtils.MapToBean(req.getParameterMap(), new User());
        String Vcode = (String) req.getSession().getAttribute("KAPTCHA_SESSION_KEY");
        req.getSession().removeAttribute("KAPTCHA_SESSION_KEY");
        String code = req.getParameter("code");
        if(Vcode.equalsIgnoreCase(code)){
            if(userServices.isExitUser(user.getUsername())){
                req.setAttribute("msg", "用户名已存在");
                // 回显数据
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else{
                userServices.register(user);
                req.getSession().setAttribute("user", user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        }else{
            req.setAttribute("msg", "验证码错误");
            // 回显数据
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }
    }
    protected  void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            req.getSession().setAttribute("user", reUser);// 放到User域中，数据回显
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }else{
            req.setAttribute("msg", "用户名或者密码错误");
            // 回显数据
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    protected  void isExitUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        Boolean isExit = userServices.isExitUser(username);
        Map<String, Boolean> json = new HashMap<>();
        json.put("isExit", isExit);
        Gson gson = new Gson();
        String jsonStr = gson.toJson(json);
        resp.getWriter().write(jsonStr);
    }
    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected  void loginout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
