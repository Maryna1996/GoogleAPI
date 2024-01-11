package com.example.googleapi.controller;

import com.example.googleapi.service.GoogleTrendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/trends")
public class GoogleTrendsController {

    private final GoogleTrendsService googleTrendsService;

    @Autowired
    public GoogleTrendsController(GoogleTrendsService googleTrendsService) {
        this.googleTrendsService = googleTrendsService;
    }

    @GetMapping("/getTrends")
    public String getTrends(
            @RequestParam String keyword,
            @RequestParam(required = false, defaultValue = "UA") String region,
            @RequestParam(required = false, defaultValue = "UA") String country) throws IOException {
        // Form the URL for calling the method getTrendsData
        String apiUrl = "http://localhost:8080/google-trends/getTrends";
        // Call the getTrendsData method from the service, passing the parameters
        return googleTrendsService.getTrendsData(keyword, region, country, apiUrl);
    }
}