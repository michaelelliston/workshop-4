package com.yearup.dealership;

import utilities.InputGetter;

import java.util.ArrayList;

public class UserInterface {
    private Dealership dealership;
    private DealershipFileManager dealershipFileManager;
    private ContractFileManager contractFileManager;

    public UserInterface() {

    }

    private void initDealerShipFileManager() {
        dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    private void initContractFileManager() {
        contractFileManager = new ContractFileManager();
    }

    public void display() {
        initDealerShipFileManager();
        int  userInput = 0;
        while (!(userInput == 99)) {
            System.out.print("""
                    \n
                    1) Find vehicles within a price range
                    2) Find vehicles by make / model
                    3) Find vehicles by year range
                    4) Find vehicles by color
                    5) Find vehicles by mileage range
                    6) Find vehicles by type
                    7) List ALL vehicles
                    8) Add a vehicle
                    9) Remove a vehicle
                    10) Add a Contract
                    11) Admin menu
                    
                    99) Exit
                    
                    """);

            userInput = InputGetter.getInt("Please enter the number that corresponds to your choice: ");

            switch (userInput) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRangeRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> printVehicles(dealership.getAllVehicles());
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();
                case 10 -> displayContractsMenu();
                case 11 -> {AdminUserInterface adminUserInterface = new AdminUserInterface();
                adminUserInterface.adminLogin();}

            }
        }
    }

    private void displayContractsMenu() {
        initContractFileManager();

        int userInput = 0;
        while (!(userInput == 99)) {
            System.out.print("""
                    \n
                    1) Sale
                    2) Lease
                    
                    99) Exit
                    
                    """);

            userInput = InputGetter.getInt("Please enter the number that corresponds to your choice: ");

            switch (userInput) {
                case 1 -> processSaleContractRequest();
                case 2 -> processLeaseContractRequest();
            }
        }
    }

    private void processLeaseContractRequest() {
        String date = InputGetter.getString("Please enter the contract's creation date: ");
        String customerName = InputGetter.getString("Please enter the customer's name: ");
        String customerEmail = InputGetter.getString("Please enter the costumer's email address: ");
        Vehicle vehicle = processVehicleSelectionRequest();

        LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicle, vehicle.getPrice());
        contractFileManager.saveContract(leaseContract);
        dealership.removeVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
    }

    private void processSaleContractRequest() {
        boolean isFinanced = false;
        String date = InputGetter.getString("Please enter the contract's creation date: ");
        String customerName = InputGetter.getString("Please enter the customer's name: ");
        String customerEmail = InputGetter.getString("Please enter the costumer's email address: ");
        Vehicle vehicle = processVehicleSelectionRequest();


        int userInput = 0;
        while (!(userInput == 1) && !(userInput == 2)) {
            System.out.println("""
                    \n
                    1) Financed
                    2) Not Financed
                   
                   """);

            userInput = InputGetter.getInt("Please enter the number which corresponds to your selection: ");

            if (userInput == 1) {
                isFinanced = true;
            }
        }
        SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicle, vehicle.getPrice(), isFinanced);
        contractFileManager.saveContract(salesContract);
        dealership.removeVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
    }

    private Vehicle processVehicleSelectionRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        int i = 1;
        for (Vehicle vehicle : vehicles) {
            System.out.printf("\n%d) %s\n", i, vehicle.toString());
            i++;
        }
        int userSelection = InputGetter.getInt("\nPlease select the number which corresponds to the vehicle you wish to select: ");
        return vehicles.get(userSelection - 1);
    }

    private void processRemoveVehicleRequest() {
        Vehicle vehicle = processVehicleSelectionRequest();
        dealership.removeVehicle(vehicle);
        dealershipFileManager.saveDealership(dealership);
    }

    private Vehicle processVehicleDetailsInput() {
        int vin = InputGetter.getInt("Please enter the vehicle's VIN: ");
        int year = InputGetter.getInt("Please enter the year the vehicle was manufactured: ");
        String make = InputGetter.getString("Please enter the vehicle's make: ");
        String model = InputGetter.getString("Please enter the vehicle's model: ");
        String type = InputGetter.getString("Please enter the vehicle's type: ");
        String color = InputGetter.getString("Please enter the vehicle's color: ");
        int odometer = InputGetter.getInt("Please enter the vehicle's odometer value (mileage): ");
        double price = InputGetter.getInt("Please enter the vehicle's price: ");
        return new Vehicle(vin, year, make, model, type, color, odometer, price);
    }

    private void processAddVehicleRequest() {
        Vehicle vehicle = processVehicleDetailsInput();
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
        String color = InputGetter.getString("Please enter your desired color: ");
        ArrayList<Vehicle> vehiclesByColor = dealership.getVehiclesByColor(color);
        printVehicles(vehiclesByColor);
    }

    private void processGetByYearRangeRequest() {
        int yearStart = InputGetter.getInt("Please enter the earlier year of your search range: ");
        int yearEnd = InputGetter.getInt("Please enter the later year of your search range: ");
        ArrayList<Vehicle> vehiclesByYear = dealership.getVehiclesByYear(yearStart, yearEnd);
        printVehicles(vehiclesByYear);
    }

    private void processGetByMakeModelRequest() {
        String make = InputGetter.getString("Please enter your desired Make: ");
        String model = InputGetter.getString("Please enter your desired Model: ");
        ArrayList<Vehicle> vehiclesByMakeModel = dealership.getVehiclesByMakeModel(make, model);
        printVehicles(vehiclesByMakeModel);
    }

    private void processGetByPriceRequest() {
        double minimum = InputGetter.getDouble("Please enter your minimum price: ");
        double maximum = InputGetter.getDouble("Please enter your maximum price: ");
        ArrayList<Vehicle> vehiclesByPrice = dealership.getVehiclesByPrice(minimum, maximum);
        printVehicles(vehiclesByPrice);
    }

    private void printVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println();
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
        InputGetter.getString("\n\nPlease enter any character to continue: ");
    }
}
