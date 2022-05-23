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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataCommand {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private String description;

	@JsonSerialize
	@JsonDeserialize
	private boolean enabled;

	@JsonSerialize
	@JsonDeserialize
	private List<String> aliases;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataCommandArgument> arguments;

	@JsonSerialize
	@JsonDeserialize
	private List<String> allowedRoles;

	@JsonSerialize
	@JsonDeserialize
	private List<String> allowedChannels;

	@JsonCreator
	public BotDataCommand(
			@JsonProperty("name") String name,
			@JsonProperty("description") String description,
			@JsonProperty("enabled") boolean enabled,
			@JsonProperty("aliases") List<String> aliases,
			@JsonProperty("arguments") List<BotDataCommandArgument> arguments,
			@JsonProperty("allowedRoles") List<String> allowedRoles,
			@JsonProperty("allowedChannels") List<String> allowedChannels
	) {
		this.name = name;
		this.description = description;
		this.enabled = enabled;
		this.aliases = aliases;
		this.arguments = arguments;
		this.allowedRoles = allowedRoles;
		this.allowedChannels = allowedChannels;
	}
}