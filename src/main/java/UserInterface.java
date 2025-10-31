import utilities.InputGetter;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;

    public UserInterface() {

    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {
        init();
        String userInput = "";
        while (!userInput.equalsIgnoreCase("X")) {
            System.out.print("""
                    \n
                    P) Find vehicles within a price range
                    M) Find vehicles by make / model
                    Y) Find vehicles by year range
                    C) Find vehicles by color
                    O) Find vehicles by mileage range
                    T) Find vehicles by type
                    L) List ALL vehicles
                    A) Add a vehicle
                    R) Remove a vehicle
                    
                    X) Exit
                    
                    """);

            userInput = InputGetter.getString("Please input the character that corresponds to your choice: ").toLowerCase();

            switch (userInput) {
                case "p" -> processGetByPriceRequest();
                case "m" -> processGetByMakeModelRequest();
                case "y" -> processGetByYearRangeRequest();
                case "c" -> processGetByColorRequest();
                case "l" -> printVehicles(dealership.getAllVehicles());

            }
        }
    }

    private void processGetByColorRequest() {
        String color = InputGetter.getString("Please input your desired color: ");
        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        printVehicles(vehiclesByColor);
    }

    private void processGetByYearRangeRequest() {
        int yearStart = InputGetter.getInt("Please input the earlier year of your search range: ");
        int yearEnd = InputGetter.getInt("Please input the later year of your search range: ");
        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(yearStart, yearEnd);
        printVehicles(vehiclesByYear);
    }

    private void processGetByMakeModelRequest() {
        String make = InputGetter.getString("Please input your desired Make: ");
        String model = InputGetter.getString("Please input your desired Model: ");
        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        printVehicles(vehiclesByMakeModel);
    }

    private void processGetByPriceRequest() {
        double minimum = InputGetter.getDouble("Please input your minimum price: ");
        double maximum = InputGetter.getDouble("Please input your maximum price: ");
        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minimum, maximum);
        printVehicles(vehiclesByPrice);
    }

    private void printVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
        InputGetter.getString("\n\nPlease input any character to continue: ");
    }
}
