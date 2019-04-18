package com.lfaa.tinyurl.domain.entity;

import lombok.Getter;

import java.time.LocalDateTime;

public class URLInfo {
    @Getter private LocalDateTime createdDate;
    @Getter private Long userId;

    public URLInfo(long userId) {
        this.createdDate = LocalDateTime.now();
        this.userId = userId;
    }
}
