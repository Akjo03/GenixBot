package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotDiscordConfig {
	@JsonSerialize
	@JsonDeserialize
	private String commandPrefix;

	@JsonCreator
	public BotDiscordConfig(
			@JsonProperty("commandPrefix") String commandPrefix
	) {
		this.commandPrefix = commandPrefix;
	}
}