package com.example.googleapi.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.boot.web.servlet.error.ErrorController;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorControllerImpl implements ErrorController, com.example.googleapi.controller.ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        // Get the status code
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // Handle different HTTP status codes appropriately
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error-404"; // Assuming you have a view named "error-404"
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error-500"; // Assuming you have a view named "error-500"
            }
        }

        // Default error view
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}


