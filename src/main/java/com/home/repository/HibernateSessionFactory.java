package com.home.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by atodorov on 1/23/2017.
 */
public class HibernateSessionFactory {
    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
