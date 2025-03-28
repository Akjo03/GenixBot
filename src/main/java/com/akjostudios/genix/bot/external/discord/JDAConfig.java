package com.akjostudios.genix.bot.external.discord;

import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class JDAConfig {
    private final JDAProperties properties;

    @Bean
    public @NotNull JDA jda() {
        return JDABuilder.create(
                properties.getToken(),
                GatewayIntent.getIntents(GatewayIntent.ALL_INTENTS)
        ).build();
    }
}