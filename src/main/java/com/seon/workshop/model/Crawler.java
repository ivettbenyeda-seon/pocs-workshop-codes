package com.seon.workshop.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.seon.workshop.dto.CrawlingResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Crawler {
    @JsonProperty("target_url")
    private String targetUrl;

    private Boolean isUserRegistered() {
//NOTE: always give true for now but should be implemented
        return true;
    }

    public CrawlingResult crawl_data() {
        Boolean registered = this.isUserRegistered();
        return new CrawlingResult(this.targetUrl, registered);
    }
}
