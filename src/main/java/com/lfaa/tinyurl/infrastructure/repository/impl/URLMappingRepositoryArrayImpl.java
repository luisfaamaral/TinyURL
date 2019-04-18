package com.lfaa.tinyurl.infrastructure.repository.impl;

import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class URLMappingRepositoryArrayImpl implements URLMappingRepository {
    private List<URLMapping> urlMappingList = new ArrayList<>();
    private long INITIAL_URL_MAPPING_INDEX = 1;

    @Override
    public void save(URLMapping urlMapping) {
        urlMapping.setId(INITIAL_URL_MAPPING_INDEX++);
        this.urlMappingList.add(urlMapping);
    }

    @Override
    public List<URLMapping> findAll() {
        return this.urlMappingList;
    }

    @Override
    public List<URLMapping> findAllByUserId(long userId) {
        return this.urlMappingList.stream().filter(um -> um.getUrlInfo().getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public Optional<URLMapping> findByTinyURL(String tinyURL) {
        return this.urlMappingList.stream().filter(um -> um.getTiny().getUrl().contains(tinyURL)).findAny();
    }
}
