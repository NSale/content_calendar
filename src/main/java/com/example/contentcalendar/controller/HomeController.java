package com.example.contentcalendar.controller;

import com.example.contentcalendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @Value("${cc.message: Welcome}")
    private String message;
    @Value("${cc.about}")
    private String about;
    @GetMapping("")
    public Map<String, String> hello() {
        return Map.of("Welcome: ", message, "About: ", about);
    }

    @GetMapping("/properties")
    public ContentCalendarProperties home() {
        return properties;
    }
}
