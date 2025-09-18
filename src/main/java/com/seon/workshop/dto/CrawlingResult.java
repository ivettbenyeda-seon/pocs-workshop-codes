package com.seon.workshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@NoArgsConstructor
@AllArgsConstructor
@RedisHash("crawling_result")
public class CrawlingResult {
    @JsonProperty("url")
    @Id
    private String url;
    @JsonProperty("exists")
    private Boolean exists;
}
