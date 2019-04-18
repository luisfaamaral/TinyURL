package com.lfaa.tinyurl.application.rest.controller;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TinyURLController {
    private TinyURLService tinyURLService;

    @Autowired
    public TinyURLController(TinyURLService tinyURLService) {
        this.tinyURLService = tinyURLService;
    }

    @GetMapping("/")
    String index() {
        return  " <b><u>WEBSERVICES</u></b>"                +
                " <ul>"                                     +
                " <li>POST: /tinyurl            </li>"      +
                " <li>GET: /tinyurl             </li>"      +
                " <li>GET: /tinyurl/userid/{1}  </li>"      +
                " </ul>"                                    ;
    }

    @PostMapping("/tinyurl")
    URL saveTinyURL(@RequestBody final URLMapping urlMapping) {
        URL tinyURL = null;

        if (tinyURLService.isValidURLMapping(urlMapping)) {
            try {
                tinyURL = tinyURLService.saveURLMapping(urlMapping);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (null != tinyURL) return tinyURL;
        }

        return null;
    }

    @GetMapping("/tinyurl")
    List<URLMapping> findAllURLMapping() {
        return tinyURLService.findAllURLMapping();
    }

    @GetMapping("/tinyurl/userid/{userId}")
    List<URLMapping> findAllURLMappingByUserId(@PathVariable long userId) {
        return tinyURLService.findURLMappingByUserId(userId);
    }

    @GetMapping("/tinyurl/{url}")
    URLMapping findURLMappingByTinyURL(@PathVariable String url) {
        return tinyURLService.findURLMappingByTinyURL(url).orElse(null);
    }
}
