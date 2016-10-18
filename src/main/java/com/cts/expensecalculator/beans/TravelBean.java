package com.cts.expensecalculator.beans;

import java.io.Serializable;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class TravelBean implements Serializable {

    private static final long serialVersionUID = -641597393659423854L;
    private String tripName;
    private Double distance = 0d;
    private Double totalExpense = 0d;
    private String unit;
    private Integer totalTravellers;

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public Double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(Double totalExpense) {
        this.totalExpense = totalExpense;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getTotalTravellers() {
        return totalTravellers;
    }

    public void setTotalTravellers(Integer totalTravellers) {
        this.totalTravellers = totalTravellers;
    }
}
