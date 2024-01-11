package com.example.googleapi.model;

import org.freaknet.gtrends.api.GoogleTrendsRequest;
import org.freaknet.gtrends.api.exceptions.GoogleTrendsRequestException;

public class TrendsRequest extends GoogleTrendsRequest {

    private String keyword;

    public TrendsRequest(String keyword) throws GoogleTrendsRequestException {
        super(String.valueOf(123));
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
