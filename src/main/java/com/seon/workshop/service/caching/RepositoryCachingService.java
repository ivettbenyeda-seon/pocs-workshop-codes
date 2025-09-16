package com.seon.workshop.service.caching;


import com.seon.workshop.dto.CrawlingResult;
import com.seon.workshop.repository.CrawlerResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryCachingService implements CachingService {
    @Autowired
    public RepositoryCachingService(CrawlerResultRepository crawlerResultRepository) {this.repository=crawlerResultRepository;}
    private CrawlerResultRepository repository;
    public Iterable<CrawlingResult> findAll() {
        return repository.findAll();
    }
    public void add(String key, CrawlingResult result) {
        repository.save(result);
    }

    public CrawlingResult findByTargetUrl(String targetUrl) {
        return repository.findById(targetUrl).orElse(null);
    }
    public void delete(String key) {
        repository.deleteById(key);
    }
    public void deleteAll() {
        repository.deleteAll();
    }

}
