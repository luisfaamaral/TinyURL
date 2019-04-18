package com.lfaa.tinyurl.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.Charset;
import java.util.Base64;

@EqualsAndHashCode
public class URLMapping {
    // todo: parameter into application.properties
    private int TINY_URL_SIZE = 6;
    private String TINY_URL_PREFIX = "http://lfaa.ty/";

    @Getter private URL original;
    @Getter private URL tiny;
    @Setter @Getter private long id;
    @Getter private URLInfo urlInfo;

    public URLMapping(String original, long userId) {
        this.original = new URL(original);

        createTinyURL();
        createURLInfo(userId);
    }

    private void createTinyURL() {
        String url = Base64.getEncoder().encodeToString(DigestUtils.sha1(this.original.toString().getBytes(Charset.forName("UTF-8")))).substring(0, TINY_URL_SIZE);
        this.tiny = new URL(TINY_URL_PREFIX + url);
    }

    private void createURLInfo(long userId) {
        this.urlInfo = new URLInfo(userId);
    }
}
