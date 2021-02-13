package com.urlshortener;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ClearUrlApi {
    private static HttpURLConnection con;

    public String get_clear_url(String url){
        String clear_url;
        var urlParameters = "url=" + url;
        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
        try {

            var myurl = new URL("https://cleanuri.com/api/v1/shorten");
            con = (HttpURLConnection) myurl.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java client");

            try (var wr = new DataOutputStream(con.getOutputStream())) {

                wr.write(postData);
            }

            String content = "";
            try (var br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()))) {

                String line;

                while ((line = br.readLine()) != null) {
                    content = content + line;
                }
            } catch (IOException e) {
                System.out.println(e);
                clear_url = "error-request";
                return clear_url;
            }
            JsonElement jElement = new JsonParser().parse(content);
            JsonObject jObject = jElement.getAsJsonObject();
            jObject = jObject.getAsJsonObject("result_url");
            clear_url = jObject.getAsString();


        } catch (Exception e) {
            clear_url = "error-request";
            return clear_url;
        } finally {

            con.disconnect();
        }
        return clear_url;
    }
}
