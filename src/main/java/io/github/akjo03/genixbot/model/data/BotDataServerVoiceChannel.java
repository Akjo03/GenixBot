package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.genixbot.model.util.DiscordVoiceChannelType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@SuppressWarnings("unused")
public class BotDataServerVoiceChannel extends BotDataServerChannel<DiscordVoiceChannelType> {
	public BotDataServerVoiceChannel(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("channelType") String channelType,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName
	) {
		super(id, name, DiscordVoiceChannelType.fromKey(channelType), categoryId, categoryName);
	}
}