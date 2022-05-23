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
public class BotConfigServers {
	@JsonSerialize
	@JsonDeserialize
	private BotConfigServer mainServer;

	@JsonSerialize
	@JsonDeserialize
	private BotConfigServer testServer;

	@JsonCreator
	public BotConfigServers(
			@JsonProperty("mainServer") BotConfigServer mainServer,
			@JsonProperty("testServer") BotConfigServer testServer
	) {
		this.mainServer = mainServer;
		this.testServer = testServer;
	}
}