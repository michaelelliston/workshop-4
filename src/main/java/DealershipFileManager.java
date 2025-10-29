import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {

    public Dealership getDealership() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/WorkshopFiles/inventory.csv"))) {

            String[] parts = bufferedReader.readLine().split("\\|");

            return new Dealership(parts[0], parts[1], parts[2]);

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
