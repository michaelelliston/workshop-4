package com.yearup.dealership;

public class SalesContract extends Contract {
    private final double recordingFee;
    private boolean isFinanced;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, boolean isFinanced) {
        super(date, customerName, customerEmail, vehicle, price);
        this.vehicle = vehicle;
        this.recordingFee = 100;
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount() {
        return this.totalPrice * .05;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public double getProcessingFee() {
        if (this.totalPrice >= 10000) {
            return 495;
        } else {
            return 295;
        }
    }

    public String isFinanced() {
        if (isFinanced) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public void setIsFinanced(boolean isFinanced) {
        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice() {

        double totalPrice = this.totalPrice + this.getSalesTaxAmount() + this.recordingFee;

        return totalPrice + this.getProcessingFee();
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced) {

            if (this.monthlyPayment > 0) {
                return this.monthlyPayment;
            }

            double totalPrice = this.getTotalPrice();

            if (totalPrice >= 10000) {

                return (totalPrice / 48) + ((totalPrice / 48) * 0.0425);

            } else {

                return (totalPrice / 24) + ((totalPrice / 24) * .0525);

            }
        } else {
            return 0;
        }
    }
}
