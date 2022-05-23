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
public class BotConfigServerRoles {
	@JsonSerialize
	@JsonDeserialize
	private String genixRole;

	@JsonSerialize
	@JsonDeserialize
	private String akjoRole;

	@JsonSerialize
	@JsonDeserialize
	private String adminRole;

	@JsonSerialize
	@JsonDeserialize
	private String botRole;

	@JsonSerialize
	@JsonDeserialize
	private String discordModRole;

	@JsonSerialize
	@JsonDeserialize
	private String twitchModRole;

	@JsonSerialize
	@JsonDeserialize
	private String boosterRole;

	@JsonSerialize
	@JsonDeserialize
	private String twitchSubTier3Role;

	@JsonSerialize
	@JsonDeserialize
	private String twitchSubTier2Role;

	@JsonSerialize
	@JsonDeserialize
	private String twitchSubTier1Role;

	@JsonSerialize
	@JsonDeserialize
	private String twitchSubRole;

	@JsonSerialize
	@JsonDeserialize
	private String twitchVipRole;

	@JsonSerialize
	@JsonDeserialize
	private String generalRole;

	@JsonSerialize
	@JsonDeserialize
	private String liveTalkRole;

	@JsonSerialize
	@JsonDeserialize
	private String muteRole;

	@JsonSerialize
	@JsonDeserialize
	private String maintenanceRole;

	@JsonCreator
	public BotConfigServerRoles(
			@JsonProperty("genixRole") String genixRole,
			@JsonProperty("akjoRole") String akjoRole,
			@JsonProperty("adminRole") String adminRole,
			@JsonProperty("botRole") String botRole,
			@JsonProperty("discordModRole") String discordModRole,
			@JsonProperty("twitchModRole") String twitchModRole,
			@JsonProperty("boosterRole") String boosterRole,
			@JsonProperty("twitchSubTier3Role") String twitchSubTier3Role,
			@JsonProperty("twitchSubTier2Role") String twitchSubTier2Role,
			@JsonProperty("twitchSubTier1Role") String twitchSubTier1Role,
			@JsonProperty("twitchSubRole") String twitchSubRole,
			@JsonProperty("twitchVipRole") String twitchVipRole,
			@JsonProperty("generalRole") String generalRole,
			@JsonProperty("liveTalkRole") String liveTalkRole,
			@JsonProperty("muteRole") String muteRole,
			@JsonProperty("maintenanceRole") String maintenanceRole
	) {
		this.genixRole = genixRole;
		this.akjoRole = akjoRole;
		this.adminRole = adminRole;
		this.botRole = botRole;
		this.discordModRole = discordModRole;
		this.twitchModRole = twitchModRole;
		this.boosterRole = boosterRole;
		this.twitchSubTier3Role = twitchSubTier3Role;
		this.twitchSubTier2Role = twitchSubTier2Role;
		this.twitchSubTier1Role = twitchSubTier1Role;
		this.twitchSubRole = twitchSubRole;
		this.twitchVipRole = twitchVipRole;
		this.generalRole = generalRole;
		this.liveTalkRole = liveTalkRole;
		this.muteRole = muteRole;
		this.maintenanceRole = maintenanceRole;
	}
}