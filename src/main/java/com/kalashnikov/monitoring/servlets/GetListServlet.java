package com.kalashnikov.monitoring.servlets;


import com.kalashnikov.monitoring.beans.UserBean;
import com.kalashnikov.monitoring.entities.UsersEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetListServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UsersEntity> allUsers = userBean.getAllUsers();
        req.setAttribute("users",allUsers);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }
}
