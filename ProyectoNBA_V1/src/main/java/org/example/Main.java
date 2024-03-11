package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.themoviedb.org/3/genre/movie/list?language=es"))
                .header("accept", "application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJmN2VmOTNmZjAxZTE2ODJjZWRhNmQ3NjFhNTg5YjM4YSIsInN1YiI6IjY1ZTA1MDQwNTI5NGU3MDE4NjRmMjk5ZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.SUSEoIA2TJRpBSHpzAUgcUbiSqc0zMiSb8HBEJJqJSk")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        try {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body();

            // Crear un objeto Gson con pretty printing
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            // Parsear el JSON y convertirlo a un formato legible con pretty printing
            Object jsonObject = gson.fromJson(jsonResponse, Object.class);
            String prettyJsonResponse = gson.toJson(jsonObject);

            System.out.println(prettyJsonResponse);
        } catch (IOException | InterruptedException e) {
            System.err.println("Fail conecting: "+e.getMessage());
        }
    }
}