package com.example.demo3.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {

<<<<<<< HEAD
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml"); // populates the data of the configuration file

        //creating seession factory object
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
=======
         Configuration cfg = new Configuration();
         cfg.configure("src/main/resources/hibernate.cfg.xml"); // populates the data of the configuration file
         //creating seession factory object
         ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties())
                .build();
         SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);
>>>>>>> c5113ec2555ee4c9d609fb0fdc0a99bfd8b6d824

         return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}

