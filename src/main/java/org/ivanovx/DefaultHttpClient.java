package org.ivanovx;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.Version;

public class DefaultHttpClient {
    public static Document GET(String url) {
        HttpClient httpClient = HttpClient
                .newBuilder()
                .version(Version.HTTP_1_1)
                .build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> httpResponse = null;

        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        String htmlContent = httpResponse.body();;

        return Jsoup.parse(htmlContent);
    }
}
