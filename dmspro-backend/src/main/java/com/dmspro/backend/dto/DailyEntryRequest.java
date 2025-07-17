package com.dmspro.backend.dto;

public class DailyEntryRequest {

    private Long customerId;
    private double morningMilk;
    private double eveningMilk;
    private double rate;
    private double fat;
    private double snf;
    private double morningQuantity;
    private double eveningQuantity;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getMorningMilk() {
        return morningMilk;
    }

    public void setMorningMilk(double morningMilk) {
        this.morningMilk = morningMilk;
    }

    public double getEveningMilk() {
        return eveningMilk;
    }

    public void setEveningMilk(double eveningMilk) {
        this.eveningMilk = eveningMilk;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getSnf() {
        return snf;
    }

    public void setSnf(double snf) {
        this.snf = snf;
    }

    public double getMorningQuantity() {
        return morningQuantity;
    }

    public void setMorningQuantity(double morningQuantity) {
        this.morningQuantity = morningQuantity;
    }

    public double getEveningQuantity() {
        return eveningQuantity;
    }

    public void setEveningQuantity(double eveningQuantity) {
        this.eveningQuantity = eveningQuantity;
    }
}
