package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.akjo03.genixbot.model.util.DiscordChannelType;
import lombok.*;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public abstract class BotDataServerChannel<T extends DiscordChannelType> {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String id;

	@JsonSerialize
	@JsonDeserialize
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private T channelType;

	@JsonSerialize
	@JsonDeserialize
	private String categoryId;

	@JsonSerialize
	@JsonDeserialize
	private String categoryName;

	@JsonCreator
	protected BotDataServerChannel(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("channelType") T channelType,
			@JsonProperty("categoryId") String categoryId,
			@JsonProperty("categoryName") String categoryName
	) {
		this.id = id;
		this.name = name;
		this.channelType = channelType;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
}