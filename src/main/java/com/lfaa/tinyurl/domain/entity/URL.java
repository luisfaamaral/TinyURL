package com.lfaa.tinyurl.domain.entity;

import lombok.Getter;

// todo: It can be splitted in OriginalURL and TinyURL so each one have their own specifics validations and attributes
public class URL {
    @Getter private String url;

    public URL(String url) {
        this.url = url;
    }
}
