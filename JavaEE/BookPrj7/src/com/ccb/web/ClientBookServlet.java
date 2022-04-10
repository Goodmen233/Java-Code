package com.ccb.web;

import com.ccb.entity.Page;
import com.ccb.services.BookServices;
import com.ccb.services.impl.BookServicesImpl;
import com.ccb.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet {
    BookServices serv = new BookServicesImpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        Page page = serv.page(pageNo, pageSize);
        page.setUrl("client/ClientBookServlet?action=page");
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        Integer pageSize = WebUtils.parseInt(req.getParameter("pageSize"), 4);
        String max0 = req.getParameter("max");
        String min0 = req.getParameter("min");
        Integer max = WebUtils.parseInt(max0, Integer.MAX_VALUE);
        Integer min = WebUtils.parseInt(min0, 0);
        Page page = serv.pageByPrice(pageNo, pageSize, min, max);
        StringBuilder sb = new StringBuilder("client/ClientBookServlet?action=pageByPrice");
        if(max0 != null){
            sb.append("&max=" + max0);
        }
        if(min0 != null){
            sb.append("&min=" + min0);
        }
        page.setUrl(sb.toString());
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }
}
