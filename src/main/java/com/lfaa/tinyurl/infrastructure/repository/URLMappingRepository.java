package com.lfaa.tinyurl.infrastructure.repository;

import com.lfaa.tinyurl.domain.entity.URLMapping;

import java.util.List;

public interface URLMappingRepository {
    void save(URLMapping urlMapping);
    List<URLMapping> findAll();
}
