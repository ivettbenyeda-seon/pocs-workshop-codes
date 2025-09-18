package com.seon.workshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Setter
@AllArgsConstructor
public class CrawlingRequest {
    @JsonProperty("target_url")
    @NotBlank
    @URL
    private String targetUrl;

    public String getTargetUrl() {
        return targetUrl;
    }
}
