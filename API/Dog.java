package API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

import java.awt.Desktop;
import java.net.URISyntaxException;

public class Dog {
    public static void main(String[] args) {
        String url = "https://dog.ceo/api/breeds/image/random";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        String dogURL = "";
        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObject = new JSONObject(res.body());
            dogURL = (String) jsonObject.get("message");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            URL Url = new URL(dogURL);
            URLConnection conn = Url.openConnection();
            InputStream is = conn.getInputStream();

            File file = new File("/Users/sho/Downloads/dog.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            int len = 1024;
            byte[] buf = new byte[len];
            while ((len = is.read(buf, 0, len)) != -1) {
                System.out.println(len);
                fos.write(buf, 0, len);
            }
            fos.close();
            is.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
