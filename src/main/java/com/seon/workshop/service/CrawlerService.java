package com.seon.workshop.service;

import com.seon.workshop.dto.CrawlingResponse;
import com.seon.workshop.dto.CrawlingResult;
import com.seon.workshop.model.Crawler;
import com.seon.workshop.service.caching.CachingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CrawlerService {
    CachingService cachingService;

    public CrawlingResponse crawl_data(String target){
        CrawlingResult cached_result = this.cachingService.findByTargetUrl(target);
        if (cached_result != null) {return new CrawlingResponse(cached_result,true);}
        Crawler crawler = new Crawler(target);
        CrawlingResult new_data = crawler.crawl_data();
        cachingService.add(target, new_data);
        return new CrawlingResponse(new_data, false);
    }
}
