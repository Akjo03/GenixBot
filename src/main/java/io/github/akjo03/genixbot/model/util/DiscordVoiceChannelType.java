package io.github.akjo03.genixbot.model.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public enum DiscordVoiceChannelType implements DiscordChannelType {
	LIVE_TALK_CHANNEL("liveTalkChannel"),
	AFK_CHANNEL("afkChannel"),
	MUSIC_CHANNEL("musicChannel");

	private final String key;

	public static DiscordVoiceChannelType fromKey(String key) {
		return Arrays.stream(values())
				.filter(channel -> channel.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No VoiceChannel found for key \"" + key + "\""));
	}
}