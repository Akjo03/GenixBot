package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotDataConfig {
	@JsonSerialize
	@JsonDeserialize
	private String twitchUserName;

	@JsonSerialize
	@JsonDeserialize
	private String discordCommandPrefix;

	@JsonCreator
	public BotDataConfig(
			@JsonProperty("twitchUserName") String twitchUserName,
			@JsonProperty("discordCommandPrefix") String discordCommandPrefix
	) {
		this.twitchUserName = twitchUserName;
		this.discordCommandPrefix = discordCommandPrefix;
	}
}