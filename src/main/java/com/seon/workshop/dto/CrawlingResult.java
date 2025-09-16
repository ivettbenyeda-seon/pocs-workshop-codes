package com.seon.workshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("crawling_result")
public class CrawlingResult {
    @JsonProperty("url")
    @Id
    private String url;
    @JsonProperty("exists")
    private Boolean exists;

    public CrawlingResult(String url, Boolean exists) {
        this.url = url;
        this.exists = exists;
    }
}
