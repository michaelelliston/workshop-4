package com.yearup.dealership;

import utilities.InputGetter;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager dealershipFileManager;

    public UserInterface() {

    }

    private void init() {
        dealershipFileManager = new DealershipFileManager();
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
                case "o" -> processGetByMileageRequest();
                case "t" -> processGetByVehicleTypeRequest();
                case "l" -> printVehicles(dealership.getAllVehicles());
                case "a" -> processAddVehicleRequest();
                case "r" -> processRemoveVehicleRequest();

            }
        }
    }

    private void processRemoveVehicleRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        int i = 1;
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%d) %s\n", i, vehicle.toString());
            i++;
        }
        int userSelection = InputGetter.getInt("\nPlease select the number which corresponds to the vehicle you wish to remove: ");
        dealership.removeVehicle(vehicles.get(userSelection - 1));
        dealershipFileManager.saveDealership(dealership);
    }

    private void processAddVehicleRequest() {
        int vin = InputGetter.getInt("Please enter the vehicle's VIN: ");
        int year = InputGetter.getInt("Please enter the year the vehicle was manufactured: ");
        String make = InputGetter.getString("Please enter the vehicle's make: ");
        String model = InputGetter.getString("Please enter the vehicle's model: ");
        String type = InputGetter.getString("Please enter the vehicle's type: ");
        String color = InputGetter.getString("Please enter the vehicle's color: ");
        int odometer = InputGetter.getInt("Please enter the vehicle's odometer value (mileage): ");
        double price = InputGetter.getInt("Please enter the vehicle's price: ");
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
    }

    private void processGetByVehicleTypeRequest() {
        String type = InputGetter.getString("Please enter the type of vehicle you are searching for: ");
        ArrayList<Vehicle> vehiclesByType = dealership.getVehiclesByType(type);
        printVehicles(vehiclesByType);
    }

    private void processGetByMileageRequest() {
        int minMiles = InputGetter.getInt("Please enter the lower end of miles for your search range: ");
        int maxMiles = InputGetter.getInt("Please enter the upper end of miles for your search range: ");
        ArrayList<Vehicle> vehiclesByMile = dealership.getVehiclesByMileage(minMiles, maxMiles);
        printVehicles(vehiclesByMile);
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
