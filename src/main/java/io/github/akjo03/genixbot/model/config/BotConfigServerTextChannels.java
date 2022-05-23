package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotConfigServerTextChannels {
	@JsonSerialize
	@JsonDeserialize
	private String welcomeChannel;

	@JsonSerialize
	@JsonDeserialize
	private String rulesChannel;

	@JsonSerialize
	@JsonDeserialize
	private String announcementsChannel;

	@JsonSerialize
	@JsonDeserialize
	private String twitchAnnouncementsChannel;

	@JsonSerialize
	@JsonDeserialize
	private String youtubeAnnouncementsChannel;

	@JsonSerialize
	@JsonDeserialize
	private String instaAnnouncementsChannel;

	@JsonSerialize
	@JsonDeserialize
	private String twitchClipsChannel;

	@JsonSerialize
	@JsonDeserialize
	private String adminChannel;

	@JsonSerialize
	@JsonDeserialize
	private String auditLogChannel;

	@JsonSerialize
	@JsonDeserialize
	private String botLogChannel;

	@JsonSerialize
	@JsonDeserialize
	private String maintenanceInfoChannel;

	@JsonSerialize
	@JsonDeserialize
	private String maintenanceChatChannel;

	@JsonCreator
	public BotConfigServerTextChannels(
			@JsonProperty("welcomeChannel") String welcomeChannel,
			@JsonProperty("rulesChannel") String rulesChannel,
			@JsonProperty("announcementsChannel") String announcementsChannel,
			@JsonProperty("twitchAnnouncementsChannel") String twitchAnnouncementsChannel,
			@JsonProperty("youtubeAnnouncementsChannel") String youtubeAnnouncementsChannel,
			@JsonProperty("instaAnnouncementsChannel") String instaAnnouncementsChannel,
			@JsonProperty("twitchClipsChannel") String twitchClipsChannel,
			@JsonProperty("adminChannel") String adminChannel,
			@JsonProperty("auditLogChannel") String auditLogChannel,
			@JsonProperty("botLogChannel") String botLogChannel,
			@JsonProperty("maintenanceInfoChannel") String maintenanceInfoChannel,
			@JsonProperty("maintenanceChatChannel") String maintenanceChatChannel
	) {
		this.welcomeChannel = welcomeChannel;
		this.rulesChannel = rulesChannel;
		this.announcementsChannel = announcementsChannel;
		this.twitchAnnouncementsChannel = twitchAnnouncementsChannel;
		this.youtubeAnnouncementsChannel = youtubeAnnouncementsChannel;
		this.instaAnnouncementsChannel = instaAnnouncementsChannel;
		this.twitchClipsChannel = twitchClipsChannel;
		this.adminChannel = adminChannel;
		this.auditLogChannel = auditLogChannel;
		this.botLogChannel = botLogChannel;
		this.maintenanceInfoChannel = maintenanceInfoChannel;
		this.maintenanceChatChannel = maintenanceChatChannel;
	}
}