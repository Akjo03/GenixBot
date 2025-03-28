package com.akjostudios.genix.bot.external.discord;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "jda")
public class JDAProperties {
    private String token;
}