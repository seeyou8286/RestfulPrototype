package my.restful;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Chen Chao
 */
public class ApacheHttpClientGet {
    public static void main(String[] args) {
        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost getRequest = new HttpPost (
                    "http://localhost:8080/json");
            StringEntity input = new StringEntity("{\"qty\":100,\"name\":\"iPad 4\"}");
            input.setContentType("application/json");
            getRequest.setEntity(input);
            HttpResponse response = httpClient.execute(getRequest);


            if (response.getStatusLine().getStatusCode() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            httpClient.getConnectionManager().shutdown();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

}
