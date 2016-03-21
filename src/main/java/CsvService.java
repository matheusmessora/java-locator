import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvService {
    private static final String COMMA = ",";
    private static final String NEXT_LINE = "\n";

    Location location = new Location();
    List<Location> locations = new ArrayList<Location>();
    LocatorService locatorService = new LocatorService();

    public List<Location> readAndSaveCsvData(String csvFile) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        String cvsSplitBy = ",";
        String[] position = null;
        while ((line = br.readLine()) != null) {
            position = line.split(cvsSplitBy);

            String date = position[0];
            String longitude = position[1];
            String latitude = position[2];

            location.setFileDate(date);
            location.setLatitude(latitude);
            location.setLongitude(longitude);

            String time = locatorService.getTimeFromLocation(longitude, latitude, date);
            String location = locatorService.getLocation(longitude, latitude);

            this.location.setAddress(location);
            this.location.setTimezone(time);

            locations.add(this.location);
        }
        return locations;
    }

    public void writeCsvWithObject(String fileName, List<Location> locations) {

        try {
            FileWriter writer = new FileWriter(fileName);

            for (Location location : locations) {
                writer.append(location.getFileDate());
                writer.append(COMMA);
                writer.append(location.getLongitude());
                writer.append(COMMA);
                writer.append(location.getLatitude());
                writer.append(COMMA);
                writer.append(location.getAddress());
                writer.append(COMMA);
                writer.append(location.getTimezone());
                writer.append(NEXT_LINE);
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
