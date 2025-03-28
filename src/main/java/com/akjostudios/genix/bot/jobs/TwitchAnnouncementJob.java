package com.akjostudios.genix.bot.jobs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class TwitchAnnouncementJob {
    @Scheduled(fixedRate = 10000)
    public void twitchAnnouncement() {

    }
}