package com.home.service;

import com.home.model.Vehicle;
import com.home.repository.VehicleHibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by atodorov on 1/23/2017.
 */
@Service
public class VehicleService {
    @Autowired
    VehicleHibernateRepository vehicleHibernateRepository;

    public Vehicle saveMockVehicle(){
        return vehicleHibernateRepository.saveMockVehicle();
    }
}
