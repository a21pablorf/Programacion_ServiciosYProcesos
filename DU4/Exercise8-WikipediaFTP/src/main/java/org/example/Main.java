package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Introduce un codigo de pais: (Ejemplo: ES,US,IT,FR,DE,UK...)");
        String countryCode = sc.nextLine();
        if (countryCode.length() != 2) {
            System.out.println("El codigo de pais debe tener 2 caracteres");
            return;
        }
        System.out.println("Introduce una fecha y separa los datos con un espacio: (YYYY MM DD)");
        String date = sc.nextLine();
        if (date.length() != 10) {
            System.out.println("La fecha debe tener 10 caracteres");
            return;
        }
        //Formatear la fecha con barras
        date = date.replace(" ","/");

        String json = getJsonFromApi(countryCode, date);
        writeJsonToFile(json, "output.json");

        System.out.println("Archivo guardado con exito");

        uploadToFTPServer("output.json", "192.168.56.1", "pablo", "pablo");

    }

    public static String getJsonFromApi(String countryCode, String date) {
        String url="https://wikimedia.org/api/rest_v1/metrics/pageviews/top-per-country/"+ countryCode +"/all-access/"+date;

//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .GET()
//                .build();
        try {
            URL apiURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiURL.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } catch (IOException e) {
            System.err.println("Error en la conexion con la API: "+e.getMessage());
            return null;
        }
    }

    public static void writeJsonToFile(String json,String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        String prettyJsonString = gson.toJson(jp.parse(json));

        try {
            FileWriter file = new FileWriter(fileName);
            file.write(prettyJsonString);
            file.close();
        } catch (IOException e) {
            System.err.println("Error en el guardado del archivo: "+e.getMessage());
        }
    }

    public static void uploadToFTPServer(String fileName, String server, String user, String password) {
        FTPClient client = new FTPClient();
        try{
            client.connect(server,21);
            client.login(user, password);
            client.setFileType(FTPClient.BINARY_FILE_TYPE);

            FileInputStream inputStream = new FileInputStream(fileName);
            boolean uploaded = client.storeFile(fileName, inputStream);
            inputStream.close();

            if (uploaded) {
                System.out.println("File uploaded successfully.");
            } else {
                System.out.println("Error uploading file.");
            }

            client.logout();
            client.disconnect();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}