package io.github.akjo03.genixbot.model.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public enum DiscordRoleType {
	GENIX_ROLE("genixRole"),
	AKJO_ROLE("akjoRole"),
	ADMIN_ROLE("adminRole"),
	BOT_ROLE("botRole"),
	DISCORD_MOD_ROLE("discordModRole"),
	TWITCH_MOD_ROLE("twitchModRole"),
	BOOSTER_ROLE("boosterRole"),
	TWITCH_SUB_TIER_3_ROLE("twitchSubTier3Role"),
	TWITCH_SUB_TIER_2_ROLE("twitchSubTier2Role"),
	TWITCH_SUB_TIER_1_ROLE("twitchSubTier1Role"),
	TWITCH_SUB_ROLE("twitchSubRole"),
	TWITCH_VIP_ROLE("twitchVipRole"),
	GENERAL_ROLE("generalRole"),
	LIVE_TALK_ROLE("liveTalkRole"),
	MUTE_ROLE("muteRole"),
	MAINTENANCE_ROLE("maintenanceRole");

	private final String key;

	public static DiscordRoleType fromKey(String key) {
		return Arrays.stream(values())
				.filter(channel -> channel.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No DiscordRole found for key \"" + key + "\""));
	}
}