package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.akjo03.genixbot.model.util.DiscordTextChannelType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@SuppressWarnings("unused")
public class BotDataServerTextChannel extends BotDataServerChannel<DiscordTextChannelType> {
	public BotDataServerTextChannel(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("channelType") String channelType,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName
	) {
		super(id, name, DiscordTextChannelType.fromKey(channelType), categoryId, categoryName);
	}
}