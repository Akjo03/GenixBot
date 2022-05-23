package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

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

	@JsonSerialize
	@JsonDeserialize
	private BotConfigServerRoles roles;

	@JsonCreator
	public BotConfigServer(
			@JsonProperty("id") String id,
			@JsonProperty("textChannels") BotConfigServerTextChannels textChannels,
			@JsonProperty("voiceChannels") BotConfigServerVoiceChannels voiceChannels,
			@JsonProperty("roles") BotConfigServerRoles roles
	) {
		this.id = id;
		this.textChannels = textChannels;
		this.voiceChannels = voiceChannels;
		this.roles = roles;
	}
}