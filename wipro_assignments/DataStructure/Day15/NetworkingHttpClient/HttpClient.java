package Day15.NetworkingHttpClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public static void main(String[] args) throws IOException {
        // Step 1: Specify the URL
        URL url = new URL("https://developers.google.com/profile/u/hiteshnathya");

        // Step 2: Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Step 3: Set the request method (GET, POST, etc.)
        connection.setRequestMethod("GET");

        // Step 4: Connect to the URL
        connection.connect();

        // Step 5: Get the response code
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Step 6: Get the response headers
        System.out.println("Response Headers:");
        for (String header : connection.getHeaderFields().keySet()) {
            System.out.println(header + ": " + connection.getHeaderField(header));
        }

        // Step 7: Get the response body
        System.out.println("Response Body:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

        // Step 8: Close the connection
        connection.disconnect();
    }
}