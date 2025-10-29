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

    public void getAllVehicles() {
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle);
        }
    }

    public void getVehiclesByPrice(double min, double max) {
        for (Vehicle vehicle : inventory) {
            double vehiclePrice = vehicle.getPrice();
            if (vehiclePrice >= min && vehiclePrice <= max) {
                System.out.println(vehicle);
            }
        }
    }

    public void getVehiclesByMakeModel(String make, String model) {
        for (Vehicle vehicle : inventory) {
            String vehicleModel = vehicle.getModel();
            String vehicleMake = vehicle.getMake();
            if (vehicleMake.equalsIgnoreCase(make) && vehicleModel.equalsIgnoreCase(model)){
                System.out.println(vehicle);
            }
        }

    }

    public void getVehiclesByYear(int min, int max) {
        for (Vehicle vehicle : inventory) {
            int year = vehicle.year;
            if (year >= min && year <= max){
                System.out.println(vehicle);
            }
        }

    }

    public void getVehiclesByColor(String color) {
        for (Vehicle vehicle : inventory) {
            String vehicleColor = vehicle.getColor();
            if (color.equalsIgnoreCase(vehicleColor)) {
                System.out.println(vehicle);
            }
        }

    }

    public void getVehiclesByMileage(int min, int max) {
        for (Vehicle vehicle : inventory) {
            int miles = vehicle.getOdometer();
            if (miles >= min && miles <= max) {
                System.out.println(vehicle);
            }
        }
    }

    public void removeVehicle(Vehicle vehicle) {

    }
}
