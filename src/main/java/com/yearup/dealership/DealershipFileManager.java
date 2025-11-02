package com.yearup.dealership;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    private final String fileName = "/inventory.csv";

    public Dealership getDealership() {
        String[] parts;
        try (InputStream inputStream = DealershipFileManager.class.getResourceAsStream(fileName)) {

            String line;
            assert inputStream != null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            line = bufferedReader.readLine();

            parts = line.split("\\|");

            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            for (line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {

                String[] vehicleParts = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleParts[0]), Integer.parseInt(vehicleParts[1]), vehicleParts[2], vehicleParts[3], vehicleParts[4], vehicleParts[5], Integer.parseInt(vehicleParts[6]), Double.parseDouble(vehicleParts[7]));
                dealership.addVehicle(vehicle);

            }

            return dealership;

        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + e);
            return null;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
            return null;
        }
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter ("src/main/resources/inventory.csv"))) {

            String formattedString = String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhoneNumber());

            bufferedWriter.write(formattedString);
            ArrayList<Vehicle> vehicles = dealership.getAllVehicles();

            for (Vehicle vehicle : vehicles) {
                formattedString = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
                bufferedWriter.write(formattedString);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + e);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }
}
