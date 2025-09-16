package com.seon.workshop.unit.service;

import com.seon.workshop.dto.CrawlingResponse;
import com.seon.workshop.dto.CrawlingResult;
import com.seon.workshop.service.CrawlerService;
import com.seon.workshop.service.caching.InMemoryCachingService;
import com.seon.workshop.service.caching.CachingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CrawlerServiceTests {
    CachingService testCacheDb = new InMemoryCachingService();
    CrawlerService crawlerService = new CrawlerService(testCacheDb);

    @BeforeEach
    public void setUp() {
        testCacheDb.deleteAll();
    }

    @Test
    public void testCrawlDataUseCache() {
        String test_target = "www.test-target.com";
        testCacheDb.add("www.test-target.com", new CrawlingResult(test_target, true));
        CrawlingResult cached = testCacheDb.findByTargetUrl(test_target);
        CrawlingResponse result = crawlerService.crawl_data(test_target);

        assertTrue(result.getCached());
        assertEquals(cached, result.getResult() );
    }

    @Test
    public void testCrawlDataNoCache() {
        String test_target = "www.test-target.com";
        CrawlingResponse result = crawlerService.crawl_data(test_target);

        assertFalse(result.getCached());
    }
}
