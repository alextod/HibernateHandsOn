package com.home.repository;

import com.home.model.*;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Alex on 22.01.2017.
 */
@Repository
public class UserHibernateRepository {
    private static int userCount = 1;

    @Transactional
    public String saveUserHibernate(){
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("User " + userCount);
        userDetails.setJoinedDate(new Date());
        userDetails.setAddress(new Address("Lunina " + userCount, "Odessa", "Ukraine", "65000"));
        userDetails.setOfficeAddress(new Address("Shevchenko " + userCount, "Odessa", "Ukraine", "65010"));
        userDetails.setDescription("Automatically created user");
        Company company1 = new Company("Lohika", "Odessa");
        Company company2 = new Company("Epam", "Kiev");
        userDetails.getCompanies().add(company1);
        userDetails.getCompanies().add(company2);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        userDetails.setVehicle(vehicle);

        Credentials credentials1 = new Credentials("login1", "password1");
        Credentials credentials2 = new Credentials("login2", "password2");

        credentials1.setUser(userDetails);
        credentials2.setUser(userDetails);

        userDetails.getCredentials().add(credentials1);
        userDetails.getCredentials().add(credentials2);


        try {
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(userDetails);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        userCount++;
        return userDetails.toString();
    }

    @Transactional
    public String getUserHibernate() {
        UserDetails user = null;
        Session session = null;
        try{
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            user = session.get(UserDetails.class, 1);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if(session != null) {
                //session.close();
            }
        }
        System.out.println("User is - " + user);
        return user.toString();
    }
}
