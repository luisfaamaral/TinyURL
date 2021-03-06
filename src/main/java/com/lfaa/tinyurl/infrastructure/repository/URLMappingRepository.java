package com.lfaa.tinyurl.infrastructure.repository;

import com.lfaa.tinyurl.domain.entity.URLMapping;

import java.util.List;
import java.util.Optional;

public interface URLMappingRepository {
    void save(URLMapping urlMapping);
    List<URLMapping> findAll();
    List<URLMapping> findAllByUserId(long userId);
    Optional<URLMapping> findByTinyURL(String tinyURL);
}
