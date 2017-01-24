package com.home.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by atodorov on 1/24/2017.
 */
@Entity
//@DiscriminatorValue(value = "Bike")
public class TwoWheelerVehicle extends Vehicle {

    private String steeringHandle;

    public String getSteeringHandle() {
        return steeringHandle;
    }

    public void setSteeringHandle(String steeringHandle) {
        this.steeringHandle = steeringHandle;
    }
}
