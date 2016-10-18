package com.cts.expensecalculator.beans;

import java.io.Serializable;

/**
 * Created by: tejesh.ghag on 18/10/2016
 * Description:
 */
public class VehicleSpecificationBean implements Serializable {

    private static final long serialVersionUID = -4699859387222846899L;

    private Integer maxSeats = 0;
    private Double standardRate = 0d;
    private Double extraRate = 0d;
    private Double extraPercentage = 0d;
    private Double dieselDiscount = 0d;

    public Integer getMaxSeats() {
        return maxSeats;
    }

    public void setMaxSeats(Integer maxSeats) {
        this.maxSeats = maxSeats;
    }

    public Double getStandardRate() {
        return standardRate;
    }

    public void setStandardRate(Double standardRate) {
        this.standardRate = standardRate;
    }

    public Double getExtraRate() {
        return extraRate;
    }

    public void setExtraRate(Double extraRate) {
        this.extraRate = extraRate;
    }

    public Double getExtraPercentage() {
        return extraPercentage;
    }

    public void setExtraPercentage(Double extraPercentage) {
        this.extraPercentage = extraPercentage;
    }

    public Double getDieselDiscount() {
        return dieselDiscount;
    }

    public void setDieselDiscount(Double dieselDiscount) {
        this.dieselDiscount = dieselDiscount;
    }
}
