package com.seon.workshop.repository;


import com.seon.workshop.dto.CrawlingResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CrawlerResultRepository extends CrudRepository<CrawlingResult, String> {

}
