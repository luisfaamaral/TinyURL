package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;

import java.util.List;
import java.util.Optional;

public interface TinyURLService {
    URL saveURLMapping(URLMapping urlMapping);

    List<URLMapping> findAllURLMapping();
    List<URLMapping> findURLMappingByUserId(long userId);

    boolean isValidURLMapping(URLMapping urlMapping);

    Optional<URLMapping> findURLMappingByTinyURL(String tinyURL);
}
