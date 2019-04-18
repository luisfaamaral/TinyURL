package com.lfaa.tinyurl.domain.service.impl;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.TinyURLService;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TinyURLServiceImpl implements TinyURLService {
    private URLMappingRepository urlMappingRepository;

    @Autowired
    public TinyURLServiceImpl(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    @Override
    public URL saveURLMapping(URLMapping urlMapping) {
        urlMappingRepository.save(urlMapping);

        return urlMapping.getTiny();
    }

    @Override
    public List<URLMapping> findAllURLMapping() {
        return urlMappingRepository.findAll();
    }

    @Override
    public List<URLMapping> findURLMappingByUserId(long userId) {
        return urlMappingRepository.findAll().stream().filter(um -> um.getUrlInfo().getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public boolean isValidURLMapping(URLMapping urlMapping) {
        if (null == urlMapping) return false;

        // Should not reach this stat. as there is no constructor without original
        if (null == urlMapping.getOriginal()) return false;

        return true;
    }

    @Override
    public Optional<URLMapping> findURLMappingByTinyURL(String tinyURL) {
        return urlMappingRepository.findAll().stream().filter(um -> um.getTiny().getUrl().contains(tinyURL)).findFirst();
    }
}
