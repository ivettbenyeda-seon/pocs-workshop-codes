package com.seon.workshop.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CrawlingResponse {
    public CrawlingResult getResult() {
        return result;
    }

    public void setResult(CrawlingResult result) {
        this.result = result;
    }

    @JsonProperty("result")
    private CrawlingResult result;

    public Boolean getCached() {
        return cached;
    }

    public void setCached(Boolean cached) {
        this.cached = cached;
    }

    @JsonProperty("cached")
    private Boolean cached;

    public CrawlingResponse(CrawlingResult result, Boolean cached) {
        this.result = result;
        this.cached = cached;
    }
}
