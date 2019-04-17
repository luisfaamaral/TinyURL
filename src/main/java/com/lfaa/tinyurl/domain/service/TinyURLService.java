package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;

import java.util.List;

public interface TinyURLService {
    URL saveURLMapping(URLMapping urlMapping);
    List<URLMapping> findAllURLMapping();
}
