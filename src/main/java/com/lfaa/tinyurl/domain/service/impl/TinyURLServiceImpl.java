package com.lfaa.tinyurl.domain.service.impl;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.TinyURLService;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinyURLServiceImpl implements TinyURLService {
    private URLMappingRepository urlMappingRepository;

    @Autowired
    public TinyURLServiceImpl(URLMappingRepository urlMappingRepository) {
        this.urlMappingRepository = urlMappingRepository;
    }

    @Override
    public URL saveURLMapping(URLMapping urlMapping) {
        if (null == urlMapping)
            return null;

        urlMappingRepository.save(urlMapping);

        return urlMapping.getTinyUrl();
    }

    @Override
    public List<URLMapping> findAllURLMapping() {
        return urlMappingRepository.findAll();
    }
}
