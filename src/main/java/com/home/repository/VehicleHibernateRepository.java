package com.home.repository;

import com.home.model.Vehicle;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by atodorov on 1/23/2017.
 */

@Repository
public class VehicleHibernateRepository {

    public Vehicle saveMockVehicle(){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Car");

        try{
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vehicle);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return vehicle;
    }
}
