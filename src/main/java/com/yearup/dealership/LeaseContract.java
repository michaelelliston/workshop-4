package com.yearup.dealership;

public class LeaseContract extends Contract{

    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price) {
        super(date, customerName, customerEmail, vehicle, price);
        this.vehicle = vehicle;
    }

    public double getExpectedEndingValue() {
        return this.getTotalPrice() * .5;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return this.getTotalPrice() * .07;
    }

    @Override
    public double getTotalPrice() {
        return this.totalPrice + this.getLeaseFee();
    }

    @Override
    public double getMonthlyPayment() {
        double totalPrice = this.getTotalPrice();
        return (totalPrice / 36) + ((totalPrice / 36) * .04);
    }


}
