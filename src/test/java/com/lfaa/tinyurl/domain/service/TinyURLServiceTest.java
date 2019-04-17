package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.service.TinyURLService;
import com.lfaa.tinyurl.domain.service.impl.TinyURLServiceImpl;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class TinyURLServiceTest {
    @Mock
    private URLMappingRepository urlMappingRepository;

    private TinyURLService tinyURLService = new TinyURLServiceImpl(urlMappingRepository);

}