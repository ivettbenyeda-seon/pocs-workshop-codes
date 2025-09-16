package com.seon.workshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

public class CrawlingRequest {
@JsonProperty("target_url")
@NotBlank
@URL
private String targetUrl;

public CrawlingRequest(String targetUrl) {
    this.targetUrl = targetUrl;
}

public String getTargetUrl() {
    return targetUrl;
}

public void setTargetUrl(String targetUrl) {
    this.targetUrl = targetUrl;
}
}
