package com.akjostudios.genix.bot;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties
@EnableScheduling
@ConfigurationPropertiesScan
public class GenixBotApp {
    private final JDA jda;

    public static void main(String[] args) {
        SpringApplication.run(GenixBotApp.class, args);
    }

    @EventListener
    public void onApplicationStarted(@NotNull ApplicationStartedEvent ignored) {
        jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("Genix zu"));
    }
}