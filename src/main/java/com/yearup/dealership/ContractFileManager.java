package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public void saveContract(Contract contract) {
        String formattedString;

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/contracts.csv", true))) {

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
}
