package com.seon.workshop.service.caching;

import com.seon.workshop.dto.CrawlingResult;

import java.util.*;

public class InMemoryCachingService implements CachingService {
    private final Map<String, CrawlingResult> store = new HashMap<>();

    public void add(String key, CrawlingResult value) {
        store.put(key, value);
    }

    public CrawlingResult findByTargetUrl(String key) {
        return store.get(key);
    }

    public Collection<CrawlingResult> findAll() {
        return store.values();
    }

    public void deleteAll() {
        store.clear();
    }

    public void delete(String key) {
        store.remove(key);
    }
}
