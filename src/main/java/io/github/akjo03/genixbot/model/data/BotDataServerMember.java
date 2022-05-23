package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.net.URI;
import java.time.Instant;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataServerMember {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String id;

	@JsonSerialize
	@JsonDeserialize
	private String userName;

	@JsonSerialize
	@JsonDeserialize
	private String discriminator;

	@JsonSerialize
	@JsonDeserialize
	private String nickName;

	@JsonSerialize
	@JsonDeserialize
	private URI avatarUrl;

	@JsonSerialize
	@JsonDeserialize
	private boolean bot;

	@JsonSerialize
	@JsonDeserialize
	private boolean nitroUser;

	@JsonSerialize
	@JsonDeserialize
	private List<String> roles;

	@JsonSerialize
	@JsonDeserialize
	private Instant createdAt;

	@JsonSerialize
	@JsonDeserialize
	private Instant joinedAt;

	@JsonCreator
	public BotDataServerMember(
			@JsonProperty("id") String id,
			@JsonProperty("userName") String userName,
			@JsonProperty("discriminator") String discriminator,
			@JsonProperty("nickName") String nickName,
			@JsonProperty("avatarUrl") String avatarUrl,
			@JsonProperty("bot") boolean bot,
			@JsonProperty("nitroUser") boolean nitroUser,
			@JsonProperty("roles") List<String> roles,
			@JsonProperty("createdAt") String createdAt,
			@JsonProperty("joinedAt") String joinedAt
	) {
		this.id = id;
		this.userName = userName;
		this.discriminator = discriminator;
		this.nickName = nickName;
		this.avatarUrl = URI.create(avatarUrl);
		this.bot = bot;
		this.nitroUser = nitroUser;
		this.roles = roles;
		this.createdAt = Instant.parse(createdAt);
		this.joinedAt = Instant.parse(joinedAt);
	}
}