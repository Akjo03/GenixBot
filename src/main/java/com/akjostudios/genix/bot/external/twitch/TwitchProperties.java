package com.akjostudios.genix.bot.external.twitch;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "twitch")
public class TwitchProperties {
    private String clientId;
    private String clientSecret;
}