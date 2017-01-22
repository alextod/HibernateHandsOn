package com.home.repository;

import com.home.model.Address;
import com.home.model.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Alex on 22.01.2017.
 */
@Repository
public class UserHibernateRepository {
    private static int userCount = 1;
    private static SessionFactory sessionFactory = null;


    @Transactional
    public UserDetails saveUserHibernate(){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("User " + userCount);
        userDetails.setJoinedDate(new Date());
        userDetails.setAddress(new Address("Lunina " + userCount, "Odessa", "Ukraine", "65000"));
        userDetails.setOfficeAddress(new Address("Shevchenko " + userCount, "Odessa", "Ukraine", "65010"));
        userDetails.setDescription("Automatically created user");
        try {
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(userDetails);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        userCount++;
        return userDetails;
    }

    @Transactional
    public UserDetails getUserHibernate() {
        UserDetails user = null;
        try{
            Session session = getSessionFactory().openSession();
            session.beginTransaction();
            user = session.get(UserDetails.class, 1);
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("User is - " + user);
        return user;
    }

    private SessionFactory getSessionFactory(){
        if (sessionFactory == null){
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}
