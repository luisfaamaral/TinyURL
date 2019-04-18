package com.lfaa.tinyurl.domain.service.impl;

import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.UserService;
import com.lfaa.tinyurl.infrastructure.repository.URLMappingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class URLMappingServiceImplTest {
    @Mock
    URLMappingRepository urlMappingRepository;
    @Mock
    UserService userService;

    private URLMappingServiceImpl urlMappingService = new URLMappingServiceImpl(urlMappingRepository, userService);

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void save() {
        URLMapping urlMapping = new URLMapping("", 1);

        urlMappingService.save(urlMapping);

        verify(urlMappingRepository, times(1)).save(urlMapping);
    }

    @Test
    public void findAll() {
        urlMappingService.findAll();

        verify(urlMappingRepository, times(1)).findAll();
    }

    @Test
    public void findAllByUserId() {
        urlMappingService.findAllByUserId(1L);

        verify(urlMappingRepository, times(1)).findAllByUserId(1L);
    }

    @Test
    public void findByTinyURL() {
        urlMappingService.findByTinyURL("");

        verify(urlMappingRepository, times(1)).findByTinyURL("");
    }

    @Test
    public void isValidURLMapping_ifURLMappingNull_thenFalse() throws Exception {
        assertFalse(urlMappingService.isValidURLMapping(null));
    }

    @Test
    public void isValidURLMapping_ifInvalidUser_thenFalse() throws Exception {
        URLMapping urlMapping = new URLMapping("url", 1L);

        when(userService.isValidUser(1L)).thenReturn(false);

        assertFalse(urlMappingService.isValidURLMapping(urlMapping));
    }

    @Test
    public void isValidURLMapping_ifEverythingOk_thenTrue() throws Exception {
        URLMapping urlMapping = new URLMapping("url", 1L);

        when(userService.isValidUser(1L)).thenReturn(true);

        assertTrue(urlMappingService.isValidURLMapping(urlMapping));
    }
}
