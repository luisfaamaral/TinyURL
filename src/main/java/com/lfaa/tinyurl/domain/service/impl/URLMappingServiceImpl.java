package com.lfaa.tinyurl.domain.service.impl;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.URLMappingService;
import com.lfaa.tinyurl.domain.service.UserService;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.lfaa.tinyurl.domain.entity.URLMappingParam.*;

@Service
public class URLMappingServiceImpl implements URLMappingService {
    private URLMappingRepository urlMappingRepository;
    private UserService userService;

    @Autowired
    public URLMappingServiceImpl(URLMappingRepository urlMappingRepository, UserService userService) {
        this.urlMappingRepository = urlMappingRepository;
        this.userService = userService;
    }

    @Override
    public void save(URLMapping urlMapping) {
        urlMappingRepository.save(urlMapping);
    }

    @Override
    public List<URLMapping> findAll() {
        return urlMappingRepository.findAll();
    }

    @Override
    public List<URLMapping> findAllByUserId(long userId) {
        return urlMappingRepository.findAllByUserId(userId);
    }

    @Override
    public boolean isValidURLMapping(URLMapping urlMapping) throws Exception {
        if (null == urlMapping || null == urlMapping.getOriginal()) throw new Exception(URL_MAPPING_NULL_VALUES);
        if (null == urlMapping.getUrlInfo() || null == urlMapping.getUrlInfo().getUserId()) throw new Exception(URL_MAPPING_NULL_VALUES);
        if (!userService.isValidUser(urlMapping.getUrlInfo().getUserId())) throw new Exception(URL_MAPPING_INVALID_USER);

        return true;
    }

    @Override
    public Optional<URLMapping> findByTinyURL(String tinyURL) {
        return urlMappingRepository.findByTinyURL(tinyURL);
    }
}
