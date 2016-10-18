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
    public void shouldReturnCorrectFareForACPetrolSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSUVPetrolACVehicleDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(20400d));
    }

    @Test
    public void shouldReturnCorrectFareForACPetrolBus_WhenBusWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getBusPetrolACDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(20040d));
    }

    @Test
    public void shouldReturnCorrectFareForNonACPetrolSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSUVPetrolNonACVehicleDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(18000d));
    }

    @Test
    public void shouldReturnCorrectFareForNonACPetrolBus_WhenBusWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getBusPetrolNonACDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(17640d));
    }

    @Test
    public void shouldReturnCorrectFareForACDieselSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSUVDieselACVehicleDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(19200d));
    }

    @Test
    public void shouldReturnCorrectFareForNonACDieselSUV_WhenCarWith5PAXProvidedForPuneMumbaiBangalorePune() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSUVDieselNonACVehicleDetails(),getSampleTravelDetails());
        assertThat(travelBean.getTotalExpense(),equalTo(16800d));
    }

    @Test
    public void shouldReturnCorrectFareForTravellersMoreThenMaxSeats_WhenSUVCarProvidedWithMaxSeatsToMumbai_Chennai() throws TripExpenseCalculatorException {
        travelBean = service.calculateTotalTripExpense(getSUVDieselNonACVehicleDetails(),getSampleTravelDetailsWithMorePassengers());
        assertThat(travelBean.getTotalExpense(),equalTo(19752d));
    }


    private TravelBean getSampleTravelDetails() {
        TravelBean travelBean = new TravelBean();
        travelBean.setUnit("km/h");
        travelBean.setTripName("Pune-Mumbai-Bangalore-Pune");
        travelBean.setDistance(1200.0);
        travelBean.setTotalTravellers(3);
        return travelBean;
    }

    private TravelBean getSampleTravelDetailsWithMorePassengers() {
        TravelBean travelBean = new TravelBean();
        travelBean.setUnit("km/h");
        travelBean.setTripName("Mumbai-Chennai");
        travelBean.setDistance(1234.5);
        travelBean.setTotalTravellers(9);
        return travelBean;
    }

    private VehicleBean getSUVPetrolACVehicleDetails() {
        VehicleBean bean = getVehicleDetails("Petrol");
        return bean;
    }

    private VehicleBean getSUVDieselACVehicleDetails() {
        VehicleBean bean = getVehicleDetails("Diesel");
        bean.getVehicleSpecs().setDieselDiscount(1d);
        return bean;
    }

    private VehicleBean getSUVDieselNonACVehicleDetails() {
        VehicleBean bean = getVehicleDetails("Diesel");
        bean.getVehicleSpecs().setDieselDiscount(1d);
        bean.setAirConditioner(false);
        return bean;
    }

    private VehicleBean getVehicleDetails(String transmissionType) {
        VehicleSpecificationBean specs = new VehicleSpecificationBean();
        specs.setStandardRate(15d);
        specs.setMaxSeats(7);
        specs.setExtraRate(2d);
        specs.setExtraPercentage(0.02);
        VehicleBean bean = new VehicleBean();
        bean.setName("SUV");
        bean.setAirConditioner(true);
        bean.setFuelType(transmissionType);
        bean.setVehicleType("Car");
        bean.setVehicleSpecs(specs);
        return bean;
    }
    private VehicleBean getBusPetrolACDetails() {
        VehicleBean bean = getVehicleDetails("Petrol");
        bean.setVehicleType("Bus");
        return bean;
    }

    private VehicleBean getSUVPetrolNonACVehicleDetails() {
        VehicleBean bean = getVehicleDetails("Petrol");
        bean.setAirConditioner(false);
        return bean;
    }

    private VehicleBean getBusPetrolNonACDetails() {
        VehicleBean bean = getVehicleDetails("Petrol");
        bean.setAirConditioner(false);
        bean.setVehicleType("Bus");
        return bean;
    }

}