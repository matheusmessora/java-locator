import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;



public class Services {

    public String callExternalService(String api) throws Exception{
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(api);
        HttpResponse response;

        response = client.execute(request);

        if (response.getStatusLine().getStatusCode() != 200 ) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }
        return EntityUtils.toString(response.getEntity());
    }
}
