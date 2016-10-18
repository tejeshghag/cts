package com.cts.expensecalculator.util;

import com.cts.expensecalculator.beans.TravelBean;
import com.cts.expensecalculator.beans.VehicleBean;
import com.cts.expensecalculator.util.constants.TripExpenseCalculatorConstants;
import com.cts.expensecalculator.util.exception.TripExpenseCalculatorException;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class CalculateTotalTripExpenseUtil {

    public TravelBean calculateTotalTripExpense(VehicleBean vehicle, TravelBean travelBean) throws TripExpenseCalculatorException {

        if(vehicle != null && vehicle.getFuelType() != null) {
            if(vehicle.getFuelType().equalsIgnoreCase(TripExpenseCalculatorConstants.PETROL)) {
                travelBean = calculateExpensesForPetrolVehicle(vehicle, travelBean);

            } else if(vehicle.getFuelType().equalsIgnoreCase(TripExpenseCalculatorConstants.DIESEL)) {
                travelBean = calculateExpensesForDieselVehicle(vehicle, travelBean);
            }
        }
        return travelBean;
    }

    private TravelBean calculateExpensesForPetrolVehicle(VehicleBean vehicle, TravelBean travelBean) {
        Double standardRate = calculateExtraPeopleexpense(vehicle, travelBean);
        standardRate = calculateExtraExpenses(vehicle, standardRate);

        Double total = travelBean.getDistance() * standardRate;

        travelBean.setTotalExpense(total);
        return travelBean;
    }

    private TravelBean calculateExpensesForDieselVehicle(VehicleBean vehicle, TravelBean travelBean) {
        Double standardRate = calculateExtraPeopleexpense(vehicle, travelBean);
        Double total = (travelBean.getDistance() * standardRate) - vehicle.getVehicleSpecs().getDieselDiscount();
        total = calculateExtraExpenses(vehicle, total);
        travelBean.setTotalExpense(total);
        return travelBean;
    }

    private Double calculateExtraExpenses(VehicleBean vehicle, Double standardRate) {
        if(vehicle.getVehicleType() != null && vehicle.getVehicleType().equalsIgnoreCase(TripExpenseCalculatorConstants.BUS)) {
            if(vehicle.getVehicleSpecs().getExtraPercentage() != 0) {
                Double discountRate = standardRate * vehicle.getVehicleSpecs().getExtraPercentage();
                standardRate = standardRate - discountRate;
            }
        }
        if(vehicle.isAirConditioner()) {
            standardRate = standardRate + vehicle.getVehicleSpecs().getExtraRate();
        }
        return standardRate;
    }

    private Double calculateExtraPeopleexpense(VehicleBean vehicle, TravelBean travelBean) {
        Double extraExpense = 0d;
        if(vehicle.getVehicleSpecs()!=null && travelBean.getTotalTravellers() > vehicle.getVehicleSpecs().getMaxSeats()) {
            int extraHead = travelBean.getTotalTravellers() - vehicle.getVehicleSpecs().getMaxSeats();
            extraExpense = vehicle.getVehicleSpecs().getStandardRate() + extraHead;
        } else {
            extraExpense = vehicle.getVehicleSpecs().getStandardRate();
        }
        return extraExpense;
    }
}
