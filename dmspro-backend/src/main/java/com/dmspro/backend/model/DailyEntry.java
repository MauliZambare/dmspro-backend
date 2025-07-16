package com.dmspro.backend.model;

import jakarta.persistence.*;

@Entity
public class DailyEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private double morningMilk;
    private double eveningMilk;
    private double rate;
    private double fat;
    private double snf;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    // Constructors
    public DailyEntry() {}

    public DailyEntry(Long id, String date, double morningMilk, double eveningMilk, double rate, double fat, double snf, Customer customer) {
        this.id = id;
        this.date = date;
        this.morningMilk = morningMilk;
        this.eveningMilk = eveningMilk;
        this.rate = rate;
        this.fat = fat;
        this.snf = snf;
        this.customer = customer;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
