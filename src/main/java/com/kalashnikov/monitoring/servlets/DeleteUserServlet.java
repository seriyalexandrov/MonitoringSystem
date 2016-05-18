package com.kalashnikov.monitoring.servlets;

import com.kalashnikov.monitoring.beans.SettingBean;
import com.kalashnikov.monitoring.beans.UserBean;
import com.kalashnikov.monitoring.entities.SettingsEntity;
import com.kalashnikov.monitoring.entities.UsersEntity;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class DeleteUserServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @EJB
    private SettingBean settingBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("id") != null && !req.getParameter("id").equals("")) {
            int userId = Integer.valueOf(req.getParameter("id"));
            UsersEntity user = userBean.getUser(userId);
            for (SettingsEntity setting : user.getSettings()) {
                settingBean.deleteSetting(setting.getSettingId());
            }
            userBean.deleteUser(userId);
            resp.sendRedirect("list");
        }
    }
}
