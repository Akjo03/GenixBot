package com.akjostudios.genix.bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
@ConfigurationPropertiesScan
public class GenixBotApp {
    public static void main(String[] args) {
        SpringApplication.run(GenixBotApp.class, args);
    }
}