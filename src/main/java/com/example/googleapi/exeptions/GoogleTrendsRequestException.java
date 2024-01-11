package com.example.googleapi.exeptions;

import org.freaknet.gtrends.api.exceptions.GoogleTrendsClientException;

public class GoogleTrendsRequestException extends Exception {

    public GoogleTrendsRequestException(String message, GoogleTrendsClientException cause) {
        super(message, cause);
    }
}
