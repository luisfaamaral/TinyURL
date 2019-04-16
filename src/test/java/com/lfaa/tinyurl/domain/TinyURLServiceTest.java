package com.lfaa.tinyurl.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
public class TinyURLServiceTest {
    private TinyURLService tinyURLService = new TinyURLService();

    @Test
    public void createAndSaveTinyURL_ifNullLongURL_thenReturnNull() {
        assertNull(tinyURLService.createAndSaveTinyURL(null));
    }
}
