package com.yearup.dealership;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {
    private final String fileName = "src/main/resources/contracts.csv";
    private ArrayList<Contract> contracts;

    public void saveContract(Contract contract) {
        String formattedString;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {

            if (contract instanceof SalesContract) {
                formattedString = String.format("\nSALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                        contract.getDate(), contract.getCustomerName(), contract.getCustomerEmail(), contract.vehicle.getVin(), contract.vehicle.getYear(), contract.vehicle.getMake(),
                        contract.vehicle.getModel(), contract.vehicle.getVehicleType(), contract.vehicle.getColor(), contract.vehicle.getOdometer(), contract.vehicle.getPrice(),
                        ((SalesContract) contract).getSalesTaxAmount(), ((SalesContract) contract).getRecordingFee(), ((SalesContract) contract).getProcessingFee(), contract.getTotalPrice(),
                        ((SalesContract) contract).isFinanced(), contract.getMonthlyPayment());

                bufferedWriter.write(formattedString);

            } else if (contract instanceof LeaseContract) {
                formattedString = String.format("\nLEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f", contract.getDate(), contract.getCustomerName(), contract.getCustomerEmail(),
                        contract.vehicle.getVin(), contract.vehicle.getYear(), contract.vehicle.getMake(), contract.vehicle.getModel(), contract.vehicle.getVehicleType(), contract.vehicle.getColor(),
                        contract.vehicle.getOdometer(), contract.vehicle.getPrice(), ((LeaseContract) contract).getExpectedEndingValue(), ((LeaseContract) contract).getLeaseFee(),
                        contract.getTotalPrice(), contract.getMonthlyPayment());

                bufferedWriter.write(formattedString);

            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + e);
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
        }
    }
 // TODO: Fix this method
    public ArrayList<Contract> readContracts() {

        String[] parts;
        try (FileReader fileReader = new FileReader(fileName)) {

            String line = "";
            BufferedReader bufferedReader = new BufferedReader((fileReader));

            line = bufferedReader.readLine();

            parts = line.split("\\|");

            if (parts[0].equals("SALE")) {
                Vehicle vehicle = new Vehicle(Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7], parts[8], parts[9], Integer.parseInt(parts[10]), Double.parseDouble(parts[11]));
                SalesContract salesContract = new SalesContract(parts[1], parts[2], parts[3], vehicle, Double.parseDouble(parts[12]), Boolean.getBoolean((parts[13])));
                contracts.add(salesContract);
            } else {
                Vehicle vehicle = new Vehicle(Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), parts[6], parts[7], parts[8], parts[9], Integer.parseInt(parts[10]), Double.parseDouble(parts[11]));
                LeaseContract leaseContract = new LeaseContract(parts[1], parts[2], parts[3], vehicle, Double.parseDouble(parts[15]));
                contracts.add(leaseContract);
            }

            return contracts;

        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + e);
            return null;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
            return null;
        }
    }
}


