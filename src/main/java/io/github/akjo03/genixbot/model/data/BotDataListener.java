package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.akjo03.genixbot.model.util.DiscordEventType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataListener {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private DiscordEventType eventType;

	@JsonSerialize
	@JsonDeserialize
	private boolean enabled;

	@JsonCreator
	public BotDataListener(
			@JsonProperty("name") String name,
			@JsonProperty("eventType") String eventType,
			@JsonProperty("enabled") boolean enabled
	) {
		this.name = name;
		this.eventType = DiscordEventType.fromClassName(eventType);
		this.enabled = enabled;
	}
}