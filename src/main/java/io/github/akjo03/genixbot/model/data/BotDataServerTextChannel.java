package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.genixbot.model.util.DiscordTextChannelType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@ToString
@SuppressWarnings("unused")
public class BotDataServerTextChannel extends BotDataServerChannel<DiscordTextChannelType> {
	private BotDataServerTextChannel(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("channelType") String channelType,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName
	) {
		super(id, name, DiscordTextChannelType.fromKey(channelType), categoryId, categoryName);
	}
}