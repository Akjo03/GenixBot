package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotConfig {
	@JsonSerialize
	@JsonDeserialize
	private BotConfigServers servers;

	@JsonSerialize
	@JsonDeserialize
	private List<BotConfigCheck> checks;

	@JsonSerialize
	@JsonDeserialize
	private List<BotConfigCommand> commands;

	@JsonSerialize
	@JsonDeserialize
	private BotDiscordConfig discord;

	@JsonSerialize
	@JsonDeserialize
	private BotTwitchConfig twitch;

	@JsonCreator
	public BotConfig(
			@JsonProperty("servers") BotConfigServers servers,
			@JsonProperty("checks") List<BotConfigCheck> checks,
			@JsonProperty("commands") List<BotConfigCommand> commands,
			@JsonProperty("discord") BotDiscordConfig discord,
			@JsonProperty("twitch") BotTwitchConfig twitch
	) {
		this.servers = servers;
		this.checks = checks;
		this.commands = commands;
		this.discord = discord;
		this.twitch = twitch;
	}
}