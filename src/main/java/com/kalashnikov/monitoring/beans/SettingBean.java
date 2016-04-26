package com.kalashnikov.monitoring.beans;

import com.kalashnikov.monitoring.entities.SettingsEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class SettingBean {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager entityManager;

    public SettingsEntity saveNewSetting(SettingsEntity setting){
        return entityManager.merge(setting);
    }

    public void updateSetting(SettingsEntity setting){
        saveNewSetting(setting);
    }

    public SettingsEntity getSetting(int settingId){
        return entityManager.find(SettingsEntity.class,settingId);
    }

    public void deleteSetting(int settingId){
        entityManager.remove(getSetting(settingId));
    }

    public List<SettingsEntity> getAllSettings(){
        TypedQuery<SettingsEntity> namedQuery = entityManager.createNamedQuery("getAllSettings", SettingsEntity.class);
        System.out.println("namedQuery.getResultList().size()" + namedQuery.getResultList().size());
        return namedQuery.getResultList();
    }

}