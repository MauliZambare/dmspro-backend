package com.dmspro.backend.dto;

public class DailyEntryRequest {
    private Long customerId;
    private Double morningMilk;
    private Double eveningMilk;
    private Double rate;
    private Double fat;
    private Double snf;
    private Double morningQuantity;

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getMorningMilk() {
        return morningMilk;
    }

    public void setMorningMilk(Double morningMilk) {
        this.morningMilk = morningMilk;
    }

    public Double getEveningMilk() {
        return eveningMilk;
    }

    public void setEveningMilk(Double eveningMilk) {
        this.eveningMilk = eveningMilk;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getSnf() {
        return snf;
    }

    public void setSnf(Double snf) {
        this.snf = snf;
    }

    public Double getMorningQuantity() {
        return morningQuantity;
    }

    public void setMorningQuantity(Double morningQuantity) {
        this.morningQuantity = morningQuantity;
    }
}