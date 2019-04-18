package com.lfaa.tinyurl.domain.service;

import com.lfaa.tinyurl.domain.service.impl.URLMappingServiceImpl;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class TinyURLServiceTest {
    @Mock
    private URLMappingRepository urlMappingRepository;
}
