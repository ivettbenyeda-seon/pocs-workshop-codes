package com.seon.workshop.service.caching;

import com.seon.workshop.dto.CrawlingResult;

public interface CachingService {
    public Iterable<CrawlingResult> findAll();
    public void add(String key, CrawlingResult result);
    public CrawlingResult findByTargetUrl(String targetUrl);
    public void deleteAll();
    public void delete(String key);
}
