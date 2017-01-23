package com.home.model;

import javax.persistence.*;

/**
 * Created by atodorov on 1/23/2017.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int vehicleId;
    private String vehicleName;

    public Vehicle(){}

    public Vehicle(int vehicleId, String vehicleName) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", vehicleName='" + vehicleName + '\'' +
                '}';
    }
}
