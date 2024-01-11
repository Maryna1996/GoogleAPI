package com.example.googleapi.service;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Service
public class GoogleTrendsService {

    @Value("${google.api.key}")
    private String apiKey;

    @Autowired
    private HttpClient httpClient;

    @Scheduled(fixedRate = 3600000) // 3600000 ms = 1 hour
    public void updateTrendsDataPeriodically() {
        // Update trends automatically every hour
        // Call your getTrendsData method here with the required parameters
    }

    public String getTrendsData(String keyword, String region, String country, String apiUrl) throws IOException {
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        String encodedCountry = URLEncoder.encode(country, StandardCharsets.UTF_8);

        String requestUrl = apiUrl + "?key=" + apiKey + "&geo=" + encodedCountry + "&date=202101&cat=all";
        requestUrl += "&q=" + encodedKeyword;
        requestUrl += "&time=now 1-d";

        HttpGet httpGet = new HttpGet(requestUrl);

        try (InputStream responseStream = httpClient.execute(httpGet).getEntity().getContent()) {
            return convertInputStreamToString(responseStream);
        }
    }

    private String convertInputStreamToString(InputStream inputStream) {
        try (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")) {
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}

