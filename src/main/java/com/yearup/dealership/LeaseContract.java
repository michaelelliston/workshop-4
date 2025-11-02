package com.yearup.dealership;

public class LeaseContract extends Contract{

    double expectedEndingValue;
    double leaseFee;
    double monthlyPayment;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicle, price, monthlyPayment);
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

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
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
