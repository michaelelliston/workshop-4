public class Vehicle {

    int vin;
    int year;
    String make;
    String model;
    String vehicleType;
    String color;
    int odometer;
    double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {

        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;

    }

    @Override
    public String toString() {
        return String.format("VIN: %d|Year: %d|Make: %s|Model: %s|Type: %s|Color: %s|Odometer: %d|Price: $%.2f", getVin(), getYear(), getMake(), getModel(), getVehicleType(), getColor(), getOdometer(), getPrice());
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }
}
