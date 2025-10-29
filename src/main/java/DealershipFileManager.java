import java.io.*;

public class DealershipFileManager {

    public Dealership getDealership() {
        try (InputStream inputStream = DealershipFileManager.class.getResourceAsStream("/inventory.csv")) {
            assert inputStream != null; // Does this basically just say "trust me" and make the readers go through with their process regardless of if it possibly being null?
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

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
