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


public class AddAndEditUserServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @EJB
    private SettingBean settingBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameter("edit") != null) {
            Integer userId = Integer.valueOf(req.getParameter("edit"));
            UsersEntity user = userBean.getUser(userId);
            req.setAttribute("user", user);
        }
        req.getRequestDispatcher("/add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String newSettingName = req.getParameter("newSettingName");
        String newSettingValue = req.getParameter("newSettingValue");
        if (req.getParameter("userId") != null && !req.getParameter("userId").equals("")) {
            int userId = Integer.valueOf(req.getParameter("userId"));
            UsersEntity user = userBean.getUser(userId);
            user.setUserName(userName);
            user.setPassword(password);
            userBean.updateUser(user);
            if(newSettingName != null && !newSettingName.equals("")){
                settingBean.saveNewSetting(new SettingsEntity(newSettingName,newSettingValue,userId));
            }
        } else {
            userBean.saveNewUser(new UsersEntity(userName, password));
        }
        resp.sendRedirect("list");
    }

}