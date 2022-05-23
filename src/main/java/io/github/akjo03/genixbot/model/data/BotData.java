package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotData {
	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServer> servers = new ArrayList<>();

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataCheck> checks = new ArrayList<>();

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataListener> listeners = new ArrayList<>();

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataCommand> commands = new ArrayList<>();

	@JsonSerialize
	@JsonDeserialize
	private BotDataConfig config = new BotDataConfig();

	@JsonCreator
	public BotData(
			@JsonProperty("servers") List<BotDataServer> servers,
			@JsonProperty("checks") List<BotDataCheck> checks,
			@JsonProperty("listeners") List<BotDataListener> listeners,
			@JsonProperty("commands") List<BotDataCommand> commands,
			@JsonProperty("config") BotDataConfig config
	) {
		this.servers = servers;
		this.checks = checks;
		this.listeners = listeners;
		this.commands = commands;
		this.config = config;
	}
}