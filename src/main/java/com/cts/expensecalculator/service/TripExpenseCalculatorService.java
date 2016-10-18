package com.cts.expensecalculator.service;

import com.cts.expensecalculator.beans.TravelBean;
import com.cts.expensecalculator.beans.VehicleBean;
import com.cts.expensecalculator.util.exception.TripExpenseCalculatorException;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */

public interface TripExpenseCalculatorService {

    public TravelBean calculateTotalTripExpense(VehicleBean vehicle, TravelBean tripExpenseBean) throws TripExpenseCalculatorException;
}
