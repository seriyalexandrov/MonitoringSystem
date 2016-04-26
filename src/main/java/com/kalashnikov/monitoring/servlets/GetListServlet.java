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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetListServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @EJB
    private SettingBean settingBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UsersEntity> allUsers = userBean.getAllUsers();
        List<SettingsEntity> allSettings = settingBean.getAllSettings();
        Set<String> namesSet = new HashSet<>();
        for(SettingsEntity setting : allSettings){
            namesSet.add(setting.getSettingName());
        }
        List<String> namesSettings = new ArrayList<>(namesSet);
        req.setAttribute("settingsNames",namesSettings);
        req.setAttribute("users",allUsers);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }
}
