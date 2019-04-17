package com.lfaa.tinyurl.application.rest.controller;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
public class TinyURLController {
    private TinyURLService tinyURLService;

    @Autowired
    public TinyURLController(TinyURLService tinyURLService) {
        this.tinyURLService = tinyURLService;
    }

    @PostMapping("/tinyurl")
    URL createAndSaveTinyURL(@RequestBody final URLMapping urlMapping) {
        URL tinyURL = null;

        try {
            tinyURL = tinyURLService.saveURLMapping(urlMapping);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (null != tinyURL)
            return tinyURL;

        return null;
    }

    @GetMapping("/tinyurl")
    List<URLMapping> findAllURLMapping() {
        return tinyURLService.findAllURLMapping();
    }
}
