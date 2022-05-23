package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.akjo03.genixbot.model.util.DiscordServerType;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataServer {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String id;

	@JsonSerialize
	@JsonDeserialize
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private DiscordServerType type;

	@JsonSerialize
	@JsonDeserialize
	private boolean active;

	@JsonSerialize
	@JsonDeserialize
	private BotDataServerChannels channels;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServerRole> roles;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServerMember> members;

	@JsonCreator
	public BotDataServer(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("type") DiscordServerType type,
			@JsonProperty("active") boolean active,
			@JsonProperty("channels") BotDataServerChannels channels,
			@JsonProperty("roles") List<BotDataServerRole> roles,
			@JsonProperty("members") List<BotDataServerMember> members
	) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.active = active;
		this.channels = channels;
		this.roles = roles;
		this.members = members;
	}
}