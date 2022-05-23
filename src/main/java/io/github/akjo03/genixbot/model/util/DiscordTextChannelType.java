package io.github.akjo03.genixbot.model.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public enum DiscordTextChannelType implements DiscordChannelType {
	WELCOME_CHANNEL("welcomeChannel"),
	RULES_CHANNEL("rulesChannel"),
	ANNOUNCEMENTS_CHANNEL("announcementsChannel"),
	TWITCH_ANNOUNCEMENTS_CHANNEL("twitchAnnouncementsChannel"),
	YOUTUBE_ANNOUNCEMENTS_CHANNEL("youtubeAnnouncementsChannel"),
	INSTA_ANNOUNCEMENTS_CHANNEL("instaAnnouncementsChannel"),
	TWITCH_CLIPS_CHANNEL("twitchClipsChannel"),
	ADMIN_CHANNEL("adminChannel"),
	AUDIT_LOG_CHANNEL("auditLogChannel"),
	BOT_LOG_CHANNEL("botLogChannel"),
	MAINTENANCE_INFO_CHANNEL("maintenanceInfoChannel"),
	MAINTENANCE_CHAT_CHANNEL("maintenanceChatChannel");

	private final String key;

	public static DiscordTextChannelType fromKey(String key) {
		return Arrays.stream(values())
				.filter(channel -> channel.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No TextChannel found for key \"" + key + "\""));
	}
}