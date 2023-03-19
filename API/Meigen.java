package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class Meigen {
    public static void main(String[] args) {
        String url = "https://meigen.doodlenote.net/api/json.php";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            String resText = res.body().substring(1, res.body().length() - 1);
            JSONObject jsonObject = new JSONObject(resText);
            System.out.println(jsonObject.get("meigen"));
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
