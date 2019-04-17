package com.lfaa.tinyurl.domain.entity;

import lombok.Getter;

public class URL {
    @Getter private String url;

    public URL(String url) {
        this.url = url;
    }
}
