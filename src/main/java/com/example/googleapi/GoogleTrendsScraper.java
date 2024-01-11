package com.example.googleapi;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class GoogleTrendsScraper {

    public static void main(String[] args) {
        try {
            String trendsData = getGoogleTrendsData("crypto", "UA");
            System.out.println(trendsData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getGoogleTrendsData(String keyword, String country) throws IOException {
        String url = "https://trends.google.com/trends/explore?q=" + keyword + "&geo=" + country;

        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new IOException("Error connecting to Google Trends", e);
        }

        Element trendElement = document.selectFirst("div.chart-png");

        if (trendElement != null) {
            // Here you can process the element and extract the required data
            return trendElement.attr("src");
        } else {
            return "No trends data found";
        }
    }
}
