package com.example.googleapi;

import com.example.googleapi.service.GoogleTrendsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoogleTrendsServiceTest {

    @Autowired
    private GoogleTrendsService googleTrendsService;

    @Test
    public void testUpdateTrendsDataPeriodically() {
        // Simulate the launch of a method that is called automatically through a scheduled task
        googleTrendsService.updateTrendsDataPeriodically();
    }
}
