package com.lfaa.tinyurl.infrastructure.repository.impl;

import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class URLMappingRepositoryImpl implements URLMappingRepository {
    // todo: change global array to database
    private List<URLMapping> urlMappingList = new ArrayList<>();
    private long INITIAL_URL_MAPPING_INDEX = 1;

    @Override
    public void save(URLMapping urlMapping) {
        urlMapping.setId(INITIAL_URL_MAPPING_INDEX++);
        urlMappingList.add(urlMapping);
    }

    @Override
    public List<URLMapping> findAll() {
        return urlMappingList;
    }
}
