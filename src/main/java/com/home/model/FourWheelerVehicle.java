package com.home.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by atodorov on 1/24/2017.
 */
@Entity
//@DiscriminatorValue("Car")
public class FourWheelerVehicle extends Vehicle{

    private String steeringWheel;

    public String getSteeringWheel() {
        return steeringWheel;
    }

    public void setSteeringWheel(String steeringWheel) {
        this.steeringWheel = steeringWheel;
    }
}
