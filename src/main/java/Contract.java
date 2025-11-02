public class Contract {
    String date;
    String customerName;
    String customerEmail;
    Vehicle vehicle;
    double totalPrice;
    double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicle, double price, double monthlyPayment) {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
