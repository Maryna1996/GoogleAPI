package com.example.googleapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrendsController {

    @GetMapping("/")
    public String redirectToApiTrends() {
        return "redirect:/api/trends/getTrends";
    }
}
