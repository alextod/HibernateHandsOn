package com.home.controllers;

import com.home.model.Vehicle;
import com.home.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by atodorov on 1/23/2017.
 */
@RestController
@RequestMapping(value = "/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @RequestMapping(value = "/saveMockVehicle")
    public Vehicle saveMockVehicle(){
        return vehicleService.saveMockVehicle();
    }

    @RequestMapping(value = "/testInheritance")
    public String testIheritance(){
        return vehicleService.testInheritance();
    }
}
