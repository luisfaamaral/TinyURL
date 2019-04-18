package com.lfaa.tinyurl.application.rest.controller;

import com.lfaa.tinyurl.domain.entity.URL;
import com.lfaa.tinyurl.domain.entity.URLMapping;
import com.lfaa.tinyurl.domain.service.URLMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

import static com.lfaa.tinyurl.domain.entity.URLMappingParam.URL_MAPPING_VALID;

@RestController
public class URLMappingController {
    private URLMappingService urlMappingService;

    @Autowired
    public URLMappingController(URLMappingService tinyURLService) {
        this.urlMappingService = tinyURLService;
    }

    @GetMapping("/")
    String index() {
        return " <b><u>WEBSERVICES</u></b>" +
                " <ul>" +
                " <li>POST: /tinyurl            </li>" +
                " <li>GET: /tinyurl             </li>" +
                " <li>GET: /tinyurl/userid/{1}  </li>" +
                " </ul>";
    }

    @PostMapping("/tinyurl")
    ResponseEntity save(@RequestBody final URLMapping urlMapping) {
        URL tinyURL = null;

        try {
            if (urlMappingService.isValidURLMapping(urlMapping))
                urlMappingService.save(urlMapping);

        } catch (Exception e) {
            e.printStackTrace();

            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(urlMapping, HttpStatus.OK);
    }

    @GetMapping("/tinyurl")
    List<URLMapping> findAll() {
        return urlMappingService.findAll();
    }

    @GetMapping("/tinyurl/userid/{id}")
    List<URLMapping> findAllByUserId(@PathVariable long id) {
        return urlMappingService.findAllByUserId(id);
    }

    @GetMapping("/tinyurl/{url}")
    URLMapping findByTinyURL(@PathVariable String url) {
        return urlMappingService.findByTinyURL(url).orElse(null);
    }
}
