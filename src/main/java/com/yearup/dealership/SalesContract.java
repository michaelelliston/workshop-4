package com.yearup.dealership;

public class SalesContract extends Contract {
    double salesTaxAmount;
    double recordingFee;
    double processingFee; // Should be $295 for vehicles under $10,000 and $495 for all others.
    boolean isFinanced;
    double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicle, price, monthlyPayment);
        this.recordingFee = 100;
    }

    public double getSalesTaxAmount() {
        return this.totalPrice * .05;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        if (this.totalPrice >= 10000) {
            return 495;
        } else {
            return 295;
        }
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
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
