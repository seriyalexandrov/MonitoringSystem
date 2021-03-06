package com.kalashnikov.monitoring.beans;

import com.kalashnikov.monitoring.entities.SettingsEntity;
import com.kalashnikov.monitoring.entities.UsersEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserBean {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager entityManager;

    public UsersEntity saveNewUser(UsersEntity user){
        return entityManager.merge(user);
    }
    
    public void updateUser(UsersEntity user){
        saveNewUser(user);
    }

    public UsersEntity getUser(int userId){
        return entityManager.find(UsersEntity.class, userId);
    }

    public void deleteUser(int userId){
        entityManager.remove(getUser(userId));
    }

    public List<UsersEntity> getAllUsers(){
        TypedQuery<UsersEntity> namedQuery = entityManager.createNamedQuery("getAllUsers", UsersEntity.class);
        System.out.println("namedQuery.getResultList().size()" + namedQuery.getResultList().size());
        List<UsersEntity> resultList = namedQuery.getResultList();
        for (UsersEntity usersEntity : resultList) {
            entityManager.refresh(usersEntity);
//            for (SettingsEntity setting : usersEntity.getSettings()) {
//                entityManager.refresh(setting);
//            }
        }
        return resultList;
    }

}