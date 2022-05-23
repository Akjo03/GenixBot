package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotConfigServer {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String id;

	@JsonSerialize
	@JsonDeserialize
	private BotConfigServerTextChannels textChannels;

	@JsonSerialize
	@JsonDeserialize
	private BotConfigServerVoiceChannels voiceChannels;

	@JsonCreator
	public BotConfigServer(
			@JsonProperty("id") String id,
			@JsonProperty("textChannels") BotConfigServerTextChannels textChannels,
			@JsonProperty("voiceChannels") BotConfigServerVoiceChannels voiceChannels
	) {
		this.id = id;
		this.textChannels = textChannels;
		this.voiceChannels = voiceChannels;
	}
}