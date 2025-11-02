public class LeaseContract extends Contract{

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, double monthlyPayment) {
        super(date, customerName, customerEmail, vehicle, price, monthlyPayment);
    }

    @Override
    public double getTotalPrice() {
        return 0;
    }

    @Override
    public double getMonthlyPayment() {
        return 0;
    }


}
