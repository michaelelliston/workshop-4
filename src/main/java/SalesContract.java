public class SalesContract extends Contract {
    double salesTax = .05;
    double recordingFee = 100;
    double processingFee; // Should be $295 for vehicles under $10,000 and $495 for all others.
    boolean isFinanced;
    double monthlyPayment;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicle, price, monthlyPayment);
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setIsFinanced(boolean isFinanced) {
        this.isFinanced = isFinanced;
    }

    @Override
    public double getTotalPrice() {
        double processingFee;

        double totalPrice = this.totalPrice + (this.totalPrice * this.salesTax) + this.recordingFee;

        if (totalPrice <= 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }

        return totalPrice + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (isFinanced) {

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
