package com.yearup.dealership;

import utilities.InputGetter;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminUserInterface {

    private ContractFileManager contractFileManager = new ContractFileManager();
    Scanner myScanner = new Scanner(System.in);
    static private final String password = "password123";

    public AdminUserInterface() {

    }

    public void adminLogin() {
        String userInput = "";

        while (!userInput.equals("exit")) {

            System.out.print("\nPlease enter the admin password, or type 'exit' to go back: ");
            userInput = myScanner.nextLine();


            if (userInput.equals(password)) {
                displayAdmin();
            } else {
                System.out.println("Invalid password or input, please try again.");
            }
        }
    }

    public void displayAdmin() {
        int userInput = 0;

        while (!(userInput == 99)) {
            System.out.print("""
                    \n
                    1) List all contracts
                    
                    99) Exit
                    
                    """);

            userInput = InputGetter.getInt("Please enter the number that corresponds to your choice: ");

            switch (userInput) {
                case 1 -> processDisplayAllContractsRequest(contractFileManager.readContracts());
            }
        }
    }

    private void processDisplayAllContractsRequest(ArrayList<Contract> contracts) {
        for (Contract contract : contracts) {
            System.out.println(contract);
        }

    }
}
