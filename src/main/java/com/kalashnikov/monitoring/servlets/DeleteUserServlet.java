package com.kalashnikov.monitoring.servlets;

import com.kalashnikov.monitoring.beans.UserBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteUserServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("id") != null && !req.getParameter("id").equals("")) {
            int userId = Integer.valueOf(req.getParameter("id"));
            userBean.deleteUser(userId);
            resp.sendRedirect("list");
        }
    }
}
