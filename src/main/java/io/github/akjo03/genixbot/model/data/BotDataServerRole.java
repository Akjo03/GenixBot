package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.github.akjo03.genixbot.model.util.DiscordRoleType;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataServerRole {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String id;

	@JsonSerialize
	@JsonDeserialize
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private DiscordRoleType roleType;

	@JsonCreator
	public BotDataServerRole(
			@JsonProperty("id") String id,
			@JsonProperty("name") String name,
			@JsonProperty("roleType") String roleType
	) {
		this.id = id;
		this.name = name;
		this.roleType = DiscordRoleType.fromKey(roleType);
	}
}