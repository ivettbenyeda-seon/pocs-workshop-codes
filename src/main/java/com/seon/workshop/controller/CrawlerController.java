package com.seon.workshop.controller;

import com.seon.workshop.dto.CrawlingRequest;
import com.seon.workshop.dto.CrawlingResponse;
import com.seon.workshop.dto.CrawlingResult;
import com.seon.workshop.service.caching.CachingService;
import com.seon.workshop.service.CrawlerService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class CrawlerController {
    private final CrawlerService crawlerService;
    private final CachingService cachingService;

    public CrawlerController(CrawlerService crawlerService, CachingService cachingService)
    {
        this.crawlerService = crawlerService;
        this.cachingService = cachingService;
    }
    @GetMapping("/cache")
    public Iterable<CrawlingResult> results() {
        return this.cachingService.findAll();
    }

    @PostMapping(value="/crawl", consumes = "application/json", produces = "application/json")
    public CrawlingResponse crawl(@Valid @RequestBody CrawlingRequest crawlingRequest) {
        return this.crawlerService.crawl_data(crawlingRequest.getTargetUrl());
    }
}
