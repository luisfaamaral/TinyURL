package com.lfaa.tinyurl.domain;

import org.springframework.stereotype.Service;

@Service
public class TinyURLService {
    public String createAndSaveTinyURL(String longURL) {
        if (null == longURL)
            return null;

        return longURL;
    }
}
