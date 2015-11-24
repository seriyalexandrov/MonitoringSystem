package com.kalashnikov.monitoring;

import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SystemExecutor {

    private static final Logger log = Logger.getLogger(SystemExecutor.class);

    public void execute() {

        FactoryMethod factoryMethod = new FactoryMethod();
        factoryMethod.execute();

    }

    public static void main(String[] args) {

        SystemExecutor systemExecutor = new SystemExecutor();
        systemExecutor.execute();
//        EntityManagerFactory entityManagerFactory = null;
//        EntityManager manager = null;
//        try {
//            entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
//            manager = entityManagerFactory.createEntityManager();
//
//            DataTestEntity testEntity = new DataTestEntity();
//            testEntity.setId(100);
//            testEntity.setName("Ivan");
//
//            EntityTransaction transaction = manager.getTransaction();
//            transaction.begin();
//
//            manager.persist(testEntity);
//
//            transaction.commit();
//
//        } catch (Throwable e) {
//           // e.printStackTrace();
//        } finally {
//            if(manager != null) {
//                manager.close();
//            }
//            if (entityManagerFactory != null) {
//                entityManagerFactory.close();
//            }
//        }
    }

}