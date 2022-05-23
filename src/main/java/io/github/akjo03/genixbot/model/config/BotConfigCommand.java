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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotConfigCommand {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private boolean enabled;

	@JsonSerialize
	@JsonDeserialize
	private List<String> allowedRoles;

	@JsonSerialize
	@JsonDeserialize
	private List<String> allowedChannels;

	@JsonCreator
	public BotConfigCommand(
			@JsonProperty("name") String name,
			@JsonProperty("enabled") boolean enabled,
			@JsonProperty("allowedRoles") List<String> allowedRoles,
			@JsonProperty("allowedChannels") List<String> allowedChannels
	) {
		this.name = name;
		this.enabled = enabled;
		this.allowedRoles = allowedRoles;
		this.allowedChannels = allowedChannels;
	}
}