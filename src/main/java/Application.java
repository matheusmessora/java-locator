import java.io.*;
import java.util.List;

public class Application {

    public static final String PATH_CSV = "c:\\\\project\\\\data.csv";
    //put the csv to read here
    public static final String CSV_FILE = "/Users/Andrei/Downloads/data.csv";

    CsvService csvService = new CsvService();

    public static void main(String[] args) {
        Application obj = new Application();
        obj.run();
    }

    public void run() {
        try {
            List<Location> locations = csvService.readAndSaveCsvData(CSV_FILE);
            csvService.writeCsvWithObject(PATH_CSV, locations);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

    }


}
