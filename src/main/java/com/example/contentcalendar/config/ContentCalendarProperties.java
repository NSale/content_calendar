package com.example.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "bb")
public record ContentCalendarProperties(String welcomeMessage, String aboutMessage) {

}
