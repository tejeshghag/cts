package com.cts.expensecalculator.service;

import com.cts.expensecalculator.beans.TravelBean;
import com.cts.expensecalculator.beans.VehicleBean;
import com.cts.expensecalculator.util.CalculateTotalTripExpenseUtil;
import com.cts.expensecalculator.util.exception.TripExpenseCalculatorException;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description: This can be used as Service and annotated as @Service using Spring framework
 */
public class TripExpenseCalculatorServiceImpl implements TripExpenseCalculatorService {

    public TravelBean calculateTotalTripExpense(VehicleBean vehicle, TravelBean travelBean) throws TripExpenseCalculatorException {
        CalculateTotalTripExpenseUtil calculateTotalTripExpense = new CalculateTotalTripExpenseUtil();
        travelBean = calculateTotalTripExpense.calculateTotalTripExpense(vehicle, travelBean);
        return travelBean;
    }

}
