package io.github.akjo03.genixbot.model.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.dv8tion.jda.api.events.*;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.events.channel.category.CategoryDeleteEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.category.update.CategoryUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.store.StoreChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdateNameEvent;
import net.dv8tion.jda.api.events.channel.store.update.StoreChannelUpdatePositionEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.text.TextChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.text.update.*;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelCreateEvent;
import net.dv8tion.jda.api.events.channel.voice.VoiceChannelDeleteEvent;
import net.dv8tion.jda.api.events.channel.voice.update.*;
import net.dv8tion.jda.api.events.emote.EmoteAddedEvent;
import net.dv8tion.jda.api.events.emote.EmoteRemovedEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateNameEvent;
import net.dv8tion.jda.api.events.emote.update.EmoteUpdateRolesEvent;
import net.dv8tion.jda.api.events.guild.*;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteCreateEvent;
import net.dv8tion.jda.api.events.guild.invite.GuildInviteDeleteEvent;
import net.dv8tion.jda.api.events.guild.member.*;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateBoostTimeEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdatePendingEvent;
import net.dv8tion.jda.api.events.guild.update.*;
import net.dv8tion.jda.api.events.guild.voice.*;
import net.dv8tion.jda.api.events.http.HttpRequestEvent;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveAllEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEmoteEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageDeleteEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageEmbedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageUpdateEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.priv.react.PrivateMessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionRemoveEvent;
import net.dv8tion.jda.api.events.role.RoleCreateEvent;
import net.dv8tion.jda.api.events.role.RoleDeleteEvent;
import net.dv8tion.jda.api.events.role.update.*;
import net.dv8tion.jda.api.events.self.*;
import net.dv8tion.jda.api.events.user.UserActivityEndEvent;
import net.dv8tion.jda.api.events.user.UserActivityStartEvent;
import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.events.user.update.*;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
@ToString
public enum DiscordEventType {
	READY_EVENT(ReadyEvent.class),
	DISCONNECT_EVENT(DisconnectEvent.class),
	EXCEPTION_EVENT(ExceptionEvent.class),
	RESUMED_EVENT(ResumedEvent.class),
	RECONNECTED_EVENT(ReconnectedEvent.class),
	SHUTDOWN_EVENT(ShutdownEvent.class),
	STATUS_CHANGE_EVENT(StatusChangeEvent.class),
	HTTP_REQUEST_EVENT(HttpRequestEvent.class),
	RAW_GATEWAY_EVENT(RawGatewayEvent.class),
	GATEWAY_PING_EVENT(GatewayPingEvent.class),
	MESSAGE_BULK_DELETE_EVENT(MessageBulkDeleteEvent.class),
	UNAVAILABLE_GUILD_JOINED_EVENT(UnavailableGuildJoinedEvent.class),
	UNAVAILABLE_GUILD_LEAVED_EVENT(UnavailableGuildLeaveEvent.class),
	UPDATE_EVENT(UpdateEvent.class),
	SELF_UPDATE_AVATAR_EVENT(SelfUpdateAvatarEvent.class),
	SELF_UPDATE_DISCRIMINATOR_EVENT(SelfUpdateDiscriminatorEvent.class),
	SELF_UPDATE_MFA_EVENT(SelfUpdateMFAEvent.class),
	SELF_UPDATE_NAME_EVENT(SelfUpdateNameEvent.class),
	SELF_UPDATE_VERIFIED_EVENT(SelfUpdateVerifiedEvent.class),
	USER_UPDATE_ONLINE_STATUS_EVENT(UserUpdateOnlineStatusEvent.class),
	USER_UPDATE_ACTIVITIES_EVENT(UserUpdateActivitiesEvent.class),
	USER_UPDATE_ACTIVITY_ORDER_EVENT(UserUpdateActivityOrderEvent.class),
	USER_UPDATE_AVATAR_EVENT(UserUpdateAvatarEvent.class),
	USER_UPDATE_DISCRIMINATOR_EVENT(UserUpdateDiscriminatorEvent.class),
	USER_UPDATE_NAME_EVENT(UserUpdateNameEvent.class),
	USER_ACTIVITY_START_EVENT(UserActivityStartEvent.class),
	USER_ACTIVITY_END_EVENT(UserActivityEndEvent.class),
	USER_TYPING_EVENT(UserTypingEvent.class),
	MESSAGE_DELETE_EVENT(MessageDeleteEvent.class),
	MESSAGE_EMBED_EVENT(MessageEmbedEvent.class),
	MESSAGE_RECEIVED_EVENT(MessageReceivedEvent.class),
	MESSAGE_UPDATE_EVENT(MessageUpdateEvent.class),
	MESSAGE_REACTION_ADD_EVENT(MessageReactionAddEvent.class),
	MESSAGE_REACTION_REMOVE_EVENT(MessageReactionRemoveEvent.class),
	PRIVATE_MESSAGE_DELETE_EVENT(PrivateMessageDeleteEvent.class),
	PRIVATE_MESSAGE_EMBED_EVENT(PrivateMessageEmbedEvent.class),
	PRIVATE_MESSAGE_RECEIVED_EVENT(PrivateMessageReceivedEvent.class),
	PRIVATE_MESSAGE_UPDATE_EVENT(PrivateMessageUpdateEvent.class),
	PRIVATE_MESSAGE_REACTION_ADD_EVENT(PrivateMessageReactionAddEvent.class),
	PRIVATE_MESSAGE_REACTION_REMOVE_EVENT(PrivateMessageReactionRemoveEvent.class),
	GUILD_READY_EVENT(GuildReadyEvent.class),
	GUILD_AVAILABLE_EVENT(GuildAvailableEvent.class),
	GUILD_UNAVAILABLE_EVENT(GuildUnavailableEvent.class),
	GUILD_JOIN_EVENT(GuildJoinEvent.class),
	GUILD_LEAVE_EVENT(GuildLeaveEvent.class),
	GUILD_BAN_EVENT(GuildBanEvent.class),
	GUILD_UNBAN_EVENT(GuildUnbanEvent.class),
	GUILD_INVITE_CREATE_EVENT(GuildInviteCreateEvent.class),
	GUILD_INVITE_DELETE_EVENT(GuildInviteDeleteEvent.class),
	GUILD_MESSAGE_DELETE_EVENT(GuildMessageDeleteEvent.class),
	GUILD_MESSAGE_EMBED_EVENT(GuildMessageEmbedEvent.class),
	GUILD_MESSAGE_RECEIVED_EVENT(GuildMessageReceivedEvent.class),
	GUILD_MESSAGE_UPDATE_EVENT(GuildMessageUpdateEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE_ALL_EVENT(GuildMessageReactionRemoveAllEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE_EMOTE_EVENT(GuildMessageReactionRemoveEmoteEvent.class),
	GUILD_MESSAGE_REACTION_ADD_EVENT(GuildMessageReactionAddEvent.class),
	GUILD_MESSAGE_REACTION_REMOVE_EVENT(GuildMessageReactionRemoveEvent.class),
	GUILD_UPDATE_AFK_CHANNEL_EVENT(GuildUpdateAfkChannelEvent.class),
	GUILD_UPDATE_AFK_TIMEOUT_EVENT(GuildUpdateAfkTimeoutEvent.class),
	GUILD_UPDATE_EXPLICIT_CONTENT_LEVEL_EVENT(GuildUpdateExplicitContentLevelEvent.class),
	GUILD_UPDATE_FEATURES_EVENT(GuildUpdateFeaturesEvent.class),
	GUILD_UPDATE_ICON_EVENT(GuildUpdateIconEvent.class),
	GUILD_UPDATE_MFA_LEVEL_EVENT(GuildUpdateMFALevelEvent.class),
	GUILD_UPDATE_NAME_EVENT(GuildUpdateNameEvent.class),
	GUILD_UPDATE_NOTIFICATION_LEVEL_EVENT(GuildUpdateNotificationLevelEvent.class),
	GUILD_UPDATE_OWNER_EVENT(GuildUpdateOwnerEvent.class),
	GUILD_UPDATE_SPLASH_EVENT(GuildUpdateSplashEvent.class),
	GUILD_UPDATE_SYSTEM_CHANNEL_EVENT(GuildUpdateSystemChannelEvent.class),
	GUILD_UPDATE_BANNER_EVENT(GuildUpdateBannerEvent.class),
	GUILD_UPDATE_BOOST_COUNT_EVENT(GuildUpdateBoostCountEvent.class),
	GUILD_UPDATE_BOOST_TIER_EVENT(GuildUpdateBoostTierEvent.class),
	GUILD_UPDATE_DESCRIPTION_EVENT(GuildUpdateDescriptionEvent.class),
	GUILD_UPDATE_MAX_MEMBERS_EVENT(GuildUpdateMaxMembersEvent.class),
	GUILD_UPDATE_MAX_PRECENCES_EVENT(GuildUpdateMaxPresencesEvent.class),
	GUILD_UPDATE_VANITY_CODE_EVENT(GuildUpdateVanityCodeEvent.class),
	GUILD_UPDATE_VERIFICATION_LEVEL_EVENT(GuildUpdateVerificationLevelEvent.class),
	GUILD_MEMBER_JOIN_EVENT(GuildMemberJoinEvent.class),
	GUILD_MEMBER_REMOVE_EVENT(GuildMemberRemoveEvent.class),
	GUILD_MEMBER_ROLE_ADD_EVENT(GuildMemberRoleAddEvent.class),
	GUILD_MEMBER_ROLE_REMOVE_EVENT(GuildMemberRoleRemoveEvent.class),
	GUILD_MEMBER_UPDATE_EVENT(GuildMemberUpdateEvent.class),
	GUILD_MEMBER_UPDATE_NICKNAME_EVENT(GuildMemberUpdateNicknameEvent.class),
	GUILD_MEMBER_UPDATE_BOOST_TIME_EVENT(GuildMemberUpdateBoostTimeEvent.class),
	GUILD_MEMBER_UPDATE_PENDING_EVENT(GuildMemberUpdatePendingEvent.class),
	GUILD_VOICE_DEAFEN_EVENT(GuildVoiceDeafenEvent.class),
	GUILD_VOICE_GUILD_DEAFEN_EVENT(GuildVoiceGuildDeafenEvent.class),
	GUILD_VOICE_GUILD_MUTE_EVENT(GuildVoiceGuildMuteEvent.class),
	GUILD_VOICE_MUTE_EVENT(GuildVoiceMuteEvent.class),
	GUILD_VOICE_SELF_DEAFEN_EVENT(GuildVoiceSelfDeafenEvent.class),
	GUILD_VOICE_SELF_MUTE_EVENT(GuildVoiceSelfMuteEvent.class),
	GUILD_VOICE_STREAM_EVENT(GuildVoiceStreamEvent.class),
	GUILD_VOICE_SUPPRESS_EVENT(GuildVoiceSuppressEvent.class),
	GUILD_VOICE_JOIN_EVENT(GuildVoiceJoinEvent.class),
	GUILD_VOICE_LEAVE_EVENT(GuildVoiceLeaveEvent.class),
	GUILD_VOICE_MOVE_EVENT(GuildVoiceMoveEvent.class),
	TEXT_CHANNEL_CREATE_EVENT(TextChannelCreateEvent.class),
	TEXT_CHANNEL_DELETE_EVENT(TextChannelDeleteEvent.class),
	TEXT_CHANNEL_UPDATE_NAME_EVENT(TextChannelUpdateNameEvent.class),
	TEXT_CHANNEL_UPDATE_NSFW_EVENT(TextChannelUpdateNSFWEvent.class),
	TEXT_CHANNEL_UPDATE_PARENT_EVENT(TextChannelUpdateParentEvent.class),
	TEXT_CHANNEL_UPDATE_POSITION_EVENT(TextChannelUpdatePositionEvent.class),
	TEXT_CHANNEL_UPDATE_SLOWMODE_EVENT(TextChannelUpdateSlowmodeEvent.class),
	TEXT_CHANNEL_UPDATE_TOPIC_EVENT(TextChannelUpdateTopicEvent.class),
	VOICE_CHANNEL_CREATE_EVENT(VoiceChannelCreateEvent.class),
	VOICE_CHANNEL_DELETE_EVENT(VoiceChannelDeleteEvent.class),
	VOICE_CHANNEL_UPDATE_BITRATE_EVENT(VoiceChannelUpdateBitrateEvent.class),
	VOICE_CHANNEL_UPDATE_NAME_EVENT(VoiceChannelUpdateNameEvent.class),
	VOICE_CHANNEL_UPDATE_PARENT_EVENT(VoiceChannelUpdateParentEvent.class),
	VOICE_CHANNEL_UPDATE_POSITION_EVENT(VoiceChannelUpdatePositionEvent.class),
	VOICE_CHANNEL_UPDATE_USER_LIMIT_EVENT(VoiceChannelUpdateUserLimitEvent.class),
	VOICE_CHANNEL_UPDATE_REGION_EVENT(VoiceChannelUpdateRegionEvent.class),
	CATEGORY_CREATE_EVENT(CategoryCreateEvent.class),
	CATEGORY_DELETE_EVENT(CategoryDeleteEvent.class),
	CATEGORY_UPDATE_NAME_EVENT(CategoryUpdateNameEvent.class),
	CATEGORY_UPDATE_POSITION_EVENT(CategoryUpdatePositionEvent.class),
	STORE_CHANNEL_CREATE_EVENT(StoreChannelCreateEvent.class),
	STORE_CHANNEL_DELETE_EVENT(StoreChannelDeleteEvent.class),
	STORE_CHANNEL_UPDATE_POSITION_EVENT(StoreChannelUpdatePositionEvent.class),
	STORE_CHANNEL_UPDATE_NAME_EVENT(StoreChannelUpdateNameEvent.class),
	ROLE_CREATE_EVENT(RoleCreateEvent.class),
	ROLE_DELETE_EVENT(RoleDeleteEvent.class),
	ROLE_UPDATE_COLOR_EVENT(RoleUpdateColorEvent.class),
	ROLE_UPDATE_HOISTED_EVENT(RoleUpdateHoistedEvent.class),
	ROLE_UPDATE_MENTIONABLE_EVENT(RoleUpdateMentionableEvent.class),
	ROLE_UPDATE_NAME_EVENT(RoleUpdateNameEvent.class),
	ROLE_UPDATE_PERMISSIONS_EVENT(RoleUpdatePermissionsEvent.class),
	ROLE_UPDATE_POSITION_EVENT(RoleUpdatePositionEvent.class),
	EMOTE_ADDED_EVENT(EmoteAddedEvent.class),
	EMOTE_REMOVED_EVENT(EmoteRemovedEvent.class),
	EMOTE_UPDATE_NAME_EVENT(EmoteUpdateNameEvent.class),
	EMOTE_UPDATE_ROLES_EVENT(EmoteUpdateRolesEvent.class);

	private final Class<? extends GenericEvent> eventClass;

	public static DiscordEventType fromClassName(String className) {
		return Arrays.stream(values())
				.filter(type -> type.eventClass.getName().equals(className))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No event type found for class name \"" + className + "\""));
	}
}