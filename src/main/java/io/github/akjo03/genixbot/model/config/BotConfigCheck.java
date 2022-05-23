package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotConfigCheck {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private boolean enabled;

	@JsonSerialize
	@JsonDeserialize
	private long interval;

	@JsonCreator
	public BotConfigCheck(
			@JsonProperty("name") String name,
			@JsonProperty("enabled") boolean enabled,
			@JsonProperty("interval") long interval
	) {
		this.name = name;
		this.enabled = enabled;
		this.interval = interval;
	}
}