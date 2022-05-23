package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotDataServerChannels {
	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServerTextChannel> textChannels;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServerVoiceChannel> voiceChannels;

	@JsonCreator
	public BotDataServerChannels(
			@JsonProperty("textChannels") List<BotDataServerTextChannel> textChannels,
			@JsonProperty("voiceChannels") List<BotDataServerVoiceChannel> voiceChannels
	) {
		this.textChannels = textChannels;
		this.voiceChannels = voiceChannels;
	}
}