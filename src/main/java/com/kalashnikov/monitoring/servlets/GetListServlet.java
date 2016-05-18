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
import java.util.*;

public class GetListServlet extends HttpServlet {
    @EJB
    private UserBean userBean;

    @EJB
    private SettingBean settingBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<UsersEntity> allUsers = userBean.getAllUsers();
        System.out.println(" \n\n\n\n allUsers: " + allUsers.get(0).getSettings());
        List<String> settingsNames = getSettingsNames();
        ArrayList<UsersEntityAndSettings> infoList = new ArrayList<>();
        for(UsersEntity user: allUsers){
            infoList.add(new UsersEntityAndSettings(user));
        }
        req.setAttribute("settingsNames",settingsNames);
        req.setAttribute("infoList",infoList);
        req.getRequestDispatcher("/list.jsp").forward(req,resp);

    }
    private List<String> getSettingsNames(){
        List<SettingsEntity> allSettings = settingBean.getAllSettings();
        Set<String> namesSet = new HashSet<>();
        for(SettingsEntity setting : allSettings){
            namesSet.add(setting.getSettingName());
        }
        List<String> settingsNames = new ArrayList<>(namesSet);
        return settingsNames;
    }
}
