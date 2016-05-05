package com.kalashnikov.monitoring.servlets;


import com.kalashnikov.monitoring.entities.SettingsEntity;
import com.kalashnikov.monitoring.entities.UsersEntity;

import java.util.HashMap;
import java.util.Map;

public class UsersEntityAndSettings {
    private UsersEntity usersEntity;
    private Map settingsMap;

    public UsersEntityAndSettings(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
        this.settingsMap = new HashMap();
        for (SettingsEntity setting : usersEntity.getSettings()) {
            settingsMap.put(setting.getSettingName(), setting.getSettingValue());
        }
    }

    public Map getSettingsMap() {
        return settingsMap;
    }

    public void setSettingsMap(Map settingsMap) {
        this.settingsMap = settingsMap;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }
}
