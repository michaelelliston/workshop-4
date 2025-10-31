import java.util.ArrayList;

public class Dealership {

    String name;
    String address;
    String phoneNumber;
    ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phoneNumber) {

        this.inventory = new ArrayList<Vehicle>();
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(inventory);
    }

    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesByPrice = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            double vehiclePrice = vehicle.getPrice();
            if (vehiclePrice >= min && vehiclePrice <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }
        return vehiclesByPrice;
    }

    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> vehiclesByMakeModel = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            String vehicleModel = vehicle.getModel();
            String vehicleMake = vehicle.getMake();
            if (vehicleMake.equalsIgnoreCase(make) && vehicleModel.equalsIgnoreCase(model)){
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> vehiclesByYear = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            int year = vehicle.year;
            if (year >= min && year <= max){
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> vehiclesByColor = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            String vehicleColor = vehicle.getColor();
            if (color.equalsIgnoreCase(vehicleColor)) {
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        ArrayList<Vehicle> vehiclesByMileage = new ArrayList<Vehicle>();
        for (Vehicle vehicle : inventory) {
            int miles = vehicle.getOdometer();
            if (miles >= min && miles <= max) {
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }

    public void removeVehicle(Vehicle vehicle) {

    }
}
