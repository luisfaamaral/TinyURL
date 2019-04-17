package com.lfaa.tinyurl.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.util.Base64;

@EqualsAndHashCode
public class URLMapping {
    // todo: add as parameter into application.properties
    private int TINY_URL_SIZE = 6;
    private String TINY_URL_PREFIX = "http://lfaa.ty/";

    @Getter private URL url;
    @Getter private URL tinyUrl;
    @Setter @Getter private long mappingId;
    @Getter private long userId;

    public URLMapping(String longURL, long userId) {
        this.url = new URL(longURL);
        this.userId = userId;

        convertLongToTinyURL();
    }

    private void convertLongToTinyURL() {
        String url = Base64.getEncoder().encodeToString(DigestUtils.sha1(this.url.toString().getBytes(Charset.forName("UTF-8")))).substring(0, TINY_URL_SIZE);
        this.tinyUrl = new URL(TINY_URL_PREFIX + url);
    }
}
