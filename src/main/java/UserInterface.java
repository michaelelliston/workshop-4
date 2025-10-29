import java.util.Scanner;

public class UserInterface {

    Scanner myScanner = new Scanner(System.in);
    Dealership dealership;

    public UserInterface() {

    }

    private Dealership init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
        return this.dealership;
    }

    public void display() {
        init();
        String userInput = "";
        while (!userInput.equalsIgnoreCase("X")) {
            System.out.print("""
                    P) Find vehicles within a price range
                    M) Find vehicles by make / model
                    Y) Find vehicles by year range
                    C) Find vehicles by color
                    O) Find vehicles by mileage range
                    T) Find vehicles by type
                    L) List ALL vehicles
                    A) Add a vehicle
                    R) Remove a vehicle
                    
                    X) Exit""");

            userInput = myScanner.nextLine().trim();

            switch (userInput) {
//                case "P", "p" -> dealership.getVehiclesByPrice();
            }
        }

    }
}
