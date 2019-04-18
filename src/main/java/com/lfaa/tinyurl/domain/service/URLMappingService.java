package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;

import java.util.List;
import java.util.Optional;

public interface URLMappingService {
    void save(URLMapping urlMapping);

    List<URLMapping> findAll();
    List<URLMapping> findAllByUserId(long userId);
    Optional<URLMapping> findByTinyURL(String tinyURL);
    boolean isValidURLMapping(URLMapping urlMapping) throws Exception;
}
