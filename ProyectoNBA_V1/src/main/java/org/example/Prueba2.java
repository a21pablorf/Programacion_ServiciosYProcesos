package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Prueba2 {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = null;
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI("https://api.balldontlie.io/v1/teams"))
                    .header("Authorization", "6ae97d3b-11af-40b3-801b-5a99ff2138c8")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonResponse= response.body();

            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            Object jsonObject = gson.fromJson(jsonResponse, Object.class);
            String prettyJsonResponse = gson.toJson(jsonObject);

            System.out.println(prettyJsonResponse);
        } catch (URISyntaxException | InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
