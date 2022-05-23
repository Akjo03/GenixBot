package io.github.akjo03.genixbot.model.config;

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
public class BotTwitchConfig {
	@JsonSerialize
	@JsonDeserialize
	private String twitchUserName;

	@JsonCreator
	public BotTwitchConfig(
			@JsonProperty("twitchUserName") String twitchUserName
	) {
		this.twitchUserName = twitchUserName;
	}
}