package io.github.akjo03.genixbot.model.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public enum DiscordServerType {
	MAIN_SERVER("mainServer"),
	TEST_SERVER("testServer"),
	UNREGISTERED_SERVER("unregisteredServer");

	private final String key;

	public static DiscordServerType fromKey(String key) {
		return Arrays.stream(values())
				.filter(type -> type.getKey().equals(key))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No DiscordServerType found for key \"" + key + "\""));
	}
}