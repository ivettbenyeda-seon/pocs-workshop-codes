package com.seon.workshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seon.workshop.dto.CrawlingResult;

public class Crawler {
    @JsonProperty("target_url")
    private String targetUrl;

    public Crawler(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    private Boolean isUserRegistered(){
//NOTE: always give true for now but should be implemented
        return true;
    }

    public CrawlingResult crawl_data(){
        Boolean registered = this.isUserRegistered();
        return new CrawlingResult(this.targetUrl, registered);
    }
}
