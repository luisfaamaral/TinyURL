package com.lfaa.tinyurl.application.rest;

import com.lfaa.tinyurl.domain.TinyURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.*;

@Controller
public class TinyURLController {
    private TinyURLService tinyURLService;

    @Autowired
    public TinyURLController(TinyURLService tinyURLService) {
        this.tinyURLService = tinyURLService;
    }

    @PostMapping("/tinyURL")
    Response.ResponseBuilder createAndSaveTinyURL(@RequestBody final String longURL) {
        String shortURL = tinyURLService.createAndSaveTinyURL(longURL);

        if (null != shortURL)
            return Response.ok();

        return Response.serverError();
    }
}
