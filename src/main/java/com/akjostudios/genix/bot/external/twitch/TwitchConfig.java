package com.akjostudios.genix.bot.external.twitch;

import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class TwitchConfig {
    private final TwitchProperties properties;

    @Bean
    public @NotNull TwitchClient twitchClient() {
        return TwitchClientBuilder.builder()
                .withEnableHelix(true)
                .withClientId(properties.getClientId())
                .withClientSecret(properties.getClientSecret())
                .build();
    }
}