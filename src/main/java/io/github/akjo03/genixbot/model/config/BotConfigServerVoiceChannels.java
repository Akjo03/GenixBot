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
public class BotConfigServerVoiceChannels {
	@JsonSerialize
	@JsonDeserialize
	private String liveTalkChannel;

	@JsonSerialize
	@JsonDeserialize
	private String afkChannel;

	@JsonSerialize
	@JsonDeserialize
	private String musicChannel;

	@JsonCreator
	public BotConfigServerVoiceChannels(
			@JsonProperty("liveTalkChannel") String liveTalkChannel,
			@JsonProperty("afkChannel") String afkChannel,
			@JsonProperty("musicChannel") String musicChannel
	) {
		this.liveTalkChannel = liveTalkChannel;
		this.afkChannel = afkChannel;
		this.musicChannel = musicChannel;
	}
}