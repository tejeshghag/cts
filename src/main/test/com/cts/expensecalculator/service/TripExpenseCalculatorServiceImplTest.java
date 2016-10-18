package com.cts.expensecalculator.service;

import com.cts.expensecalculator.beans.TravelBean;
import com.cts.expensecalculator.beans.VehicleBean;
import com.cts.expensecalculator.beans.VehicleSpecificationBean;
import com.cts.expensecalculator.util.exception.TripExpenseCalculatorException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class TripExpenseCalculatorServiceImplTest {

    private TravelBean travelBean;
    private TripExpenseCalculatorServiceImpl service;

    @Before
    public void setUp() {
        travelBean = new TravelBean();
        service = new TripExpenseCalculatorServiceImpl();
    }

    @Test
    public void shouldResultCorrectFareForACPetrolSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSamplePetrolACVehicleDetails1(),getSampleTravelDetails1());
        assertThat(travelBean.getTotalExpense(),equalTo(20400d));
    }

    @Test
    public void shouldResultCorrectFareForACPetrolBus_WhenBusWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSamplePetrolACBusDetails(),getSampleTravelDetails1());
        assertThat(travelBean.getTotalExpense(),equalTo(20040d));
    }

    @Test
    public void shouldResultCorrectFareForNonACPetrolSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSamplePetrolNonACVehicleDetails(),getSampleTravelDetails1());
        assertThat(travelBean.getTotalExpense(),equalTo(18000d));
    }

    @Test
    public void shouldResultCorrectFareForNonACPetrolBus_WhenBusWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSamplePetrolNonACBusDetails(),getSampleTravelDetails1());
        assertThat(travelBean.getTotalExpense(),equalTo(17640d));
    }

    private TravelBean getSampleTravelDetails1() {
        TravelBean travelBean = new TravelBean();
        travelBean.setUnit("km/h");
        travelBean.setTripName("Pune-Mumbai-Bangalore-Pune");
        travelBean.setDistance(1200.0);
        travelBean.setTotalTravellers(3);
        return travelBean;
    }

    private TravelBean getSampleTravelDetails2() {
        TravelBean travelBean = new TravelBean();
        travelBean.setUnit("km/h");
        travelBean.setTripName("Mumbai-Chennai");
        travelBean.setDistance(1234.5);
        travelBean.setTotalTravellers(5);
        return travelBean;
    }

    private TravelBean getSampleTravelDetailsWithMorePassengers() {
        TravelBean travelBean = new TravelBean();
        travelBean.setUnit("km/h");
        travelBean.setTripName("Mumbai-Chennai");
        travelBean.setDistance(1234.5);
        travelBean.setTotalTravellers(10);
        return travelBean;
    }

    private VehicleBean getSamplePetrolACVehicleDetails1() {
        VehicleSpecificationBean specs = new VehicleSpecificationBean();
        specs.setStandardRate(15d);
        specs.setMaxSeats(7);
        specs.setExtraRate(2d);
        VehicleBean bean = new VehicleBean();
        bean.setName("SUV");
        bean.setAirConditioner(true);
        bean.setFuelType("Petrol");
        bean.setVehicleType("Car");
        bean.setVehicleSpecs(specs);
        return bean;
    }

    private VehicleBean getSamplePetrolACBusDetails() {
        VehicleSpecificationBean specs = new VehicleSpecificationBean();
        specs.setStandardRate(15d);
        specs.setMaxSeats(7);
        specs.setExtraRate(2d);
        specs.setExtraPercentage(0.02);
        VehicleBean bean = new VehicleBean();
        bean.setName("BUS");
        bean.setAirConditioner(true);
        bean.setFuelType("Petrol");
        bean.setVehicleType("Bus");
        bean.setVehicleSpecs(specs);
        return bean;
    }

    private VehicleBean getSamplePetrolNonACVehicleDetails() {
        VehicleSpecificationBean specs = new VehicleSpecificationBean();
        specs.setStandardRate(15d);
        specs.setMaxSeats(7);
        specs.setExtraRate(2d);
        VehicleBean bean = new VehicleBean();
        bean.setName("SUV");
        bean.setAirConditioner(false);
        bean.setFuelType("Petrol");
        bean.setVehicleType("Car");
        bean.setVehicleSpecs(specs);
        return bean;
    }

    private VehicleBean getSamplePetrolNonACBusDetails() {
        VehicleSpecificationBean specs = new VehicleSpecificationBean();
        specs.setStandardRate(15d);
        specs.setMaxSeats(7);
        specs.setExtraRate(2d);
        specs.setExtraPercentage(0.02);
        VehicleBean bean = new VehicleBean();
        bean.setName("BUS");
        bean.setAirConditioner(false);
        bean.setFuelType("Petrol");
        bean.setVehicleType("Bus");
        bean.setVehicleSpecs(specs);
        return bean;
    }

}