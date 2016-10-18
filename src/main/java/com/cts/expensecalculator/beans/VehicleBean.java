package com.cts.expensecalculator.beans;

import java.io.Serializable;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class VehicleBean implements Serializable {

    private static final long serialVersionUID = -8761607009156169932L;

    private String name;
    private String fuelType;
    private boolean airConditioner;
    private String vehicleType;
    private VehicleSpecificationBean vehicleSpecs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public boolean isAirConditioner() {
        return airConditioner;
    }

    public void setAirConditioner(boolean airConditioner) {
        this.airConditioner = airConditioner;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleSpecificationBean getVehicleSpecs() {
        return vehicleSpecs;
    }

    public void setVehicleSpecs(VehicleSpecificationBean vehicleSpecs) {
        this.vehicleSpecs = vehicleSpecs;
    }
}
