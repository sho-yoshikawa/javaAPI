package API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Corona {
    public static void main(String[] args) {
        String url = "https://opendata.corona.go.jp/api/Covid19JapanAll?dataName=東京都&date=20230228";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
        try {
            HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());
            System.out.println(res);
            System.out.println(res.body().getClass());

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
//
//
//    JSONObject jsonObject = new JSONObject(res.body());
//    JSONArray itemList = jsonObject.getJSONArray("itemList");
//    JSONObject data = itemList.getJSONObject(0);
//    int nPatients = data.getInt("npatients");
//            System.out.println(nPatients);
