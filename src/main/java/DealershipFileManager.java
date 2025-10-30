import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        String[] parts;
        try (InputStream inputStream = DealershipFileManager.class.getResourceAsStream("/inventory.csv")) {
            String line;
            assert inputStream != null; // Does this basically just say "trust me" and make the readers go through with their process regardless of if it possibly being null?
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            parts = bufferedReader.readLine().split("\\|");

            Dealership dealership = new Dealership(parts[0], parts[1], parts[2]);

            do {

                line = bufferedReader.readLine();
                String[] vehicleParts = line.split("\\|");
                Vehicle vehicle = new Vehicle(Integer.parseInt(vehicleParts[0]), Integer.parseInt(vehicleParts[1]), vehicleParts[2],vehicleParts[3],vehicleParts[4], vehicleParts[5], Integer.parseInt(vehicleParts[6]), Double.parseDouble(vehicleParts[7]));
                dealership.addVehicle(vehicle);

            } while (line != null);

            return dealership;

        } catch (FileNotFoundException e) {
            System.err.println("File not found!: " + e);
            return null;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e);
            return null;
        }
    }

    public void saveDealership() {

    }
}
