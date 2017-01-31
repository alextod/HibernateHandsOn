package com.home.repository;

import com.home.model.FourWheelerVehicle;
import com.home.model.TwoWheelerVehicle;
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

    public String testInheritance(){

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Carrr");

        TwoWheelerVehicle bike = new TwoWheelerVehicle();
        bike.setVehicleName("Bike");
        bike.setSteeringHandle("Bike Steering Handle");

        FourWheelerVehicle car = new FourWheelerVehicle();
        car.setVehicleName("BMW");
        car.setSteeringWheel("BMW Steering Wheel");

        try{
            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(vehicle);
            session.save(bike);
            session.save(car);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        return "ok";
    }
}
