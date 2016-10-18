package com.cts.expensecalculator.util.exception;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class TripExpenseCalculatorException extends Exception {

    private static final long serialVersionUID = -5643293392839828617L;

    public TripExpenseCalculatorException(String message) {
        super(message);
    }

    public TripExpenseCalculatorException(Throwable cause) {
        super(cause);
    }
}
