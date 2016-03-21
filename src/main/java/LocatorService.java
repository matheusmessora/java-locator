import org.json.JSONObject;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class LocatorService {

    public String getTimeFromLocation(String longitude, String latitude, String fileDate) throws Exception {

        String api = "https://maps.googleapis.com/maps/api/timezone/json?location=" + URLEncoder.encode(longitude, "UTF-8") + ","
                + URLEncoder.encode(latitude, "UTF-8") + "&timestamp=1331766000";

        String response = new Services().callExternalService(api);

        JSONObject jsonObject = new JSONObject(response);

        String timeZone = jsonObject.getString("timeZoneId");

        DateFormat timeZoneFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        DateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = simpleFormat.parse(fileDate);
        timeZoneFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        return timeZoneFormat.format(date);

    }

    public String getLocation(String longitude, String latitude) throws Exception {
        String api = "https://maps.googleapis.com/maps/api/timezone/json?location=" + URLEncoder.encode(longitude, "UTF-8") + ","
                + URLEncoder.encode(latitude, "UTF-8") + "&timestamp=1331766000";

        String response = new Services().callExternalService(api);

        JSONObject jsonObject = new JSONObject(response);

        return jsonObject.getString("timeZoneId");
    }

}
