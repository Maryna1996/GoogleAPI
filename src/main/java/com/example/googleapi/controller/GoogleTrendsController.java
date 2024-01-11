package com.example.googleapi.controller;

import com.example.googleapi.service.GoogleTrendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/google-trends")
public class GoogleTrendsController {

    private final GoogleTrendsService googleTrendsService;

    @Autowired
    public GoogleTrendsController(GoogleTrendsService googleTrendsService) {
        this.googleTrendsService = googleTrendsService;
    }

    @GetMapping("/getTrends")
    public String getTrends(
            @RequestParam String keyword,
            @RequestParam(required = false, defaultValue = "US") String region,
            @RequestParam(required = false, defaultValue = "US") String country) throws IOException {
        return googleTrendsService.getTrendsData(keyword, region, country);
    }
}
