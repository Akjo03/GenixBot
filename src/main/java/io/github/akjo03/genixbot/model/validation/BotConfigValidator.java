package io.github.akjo03.genixbot.model.validation;

import io.github.akjo03.genixbot.model.config.*;
import io.github.akjo03.genixbot.model.util.*;
import io.github.akjo03.genixbot.util.GenixBotConstants;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import io.validly.Notification;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

import static io.validly.NoteFirstValidator.*;

@Component
public class BotConfigValidator {
	private final Logger LOGGER = LoggerManager.getLogger(BotConfigValidator.class, GenixBotConstants.LOGGING_LEVEL);

	public void validate(BotConfig botConfig) {
		Notification notification = new Notification();

		valid(botConfig, "BotConfig", notification)
				.mustNotBeNull("BotConfig must exist!");

		validateConfigServers(botConfig.getServers(), notification);
		validateChecks(botConfig.getChecks(), notification);
		validateCommands(botConfig.getCommands(), notification);

		// TODO: Add discord config validation
		// TODO: Add twitch config validation
	}

	private void validateConfigServers(BotConfigServers servers, Notification notification) {
		valid(servers, "BotConfig.servers", notification)
				.mustNotBeNull("[BotConfig] Servers must be defined!");

		BotConfigServer mainServer = servers.getMainServer();
		valid(mainServer, "BotConfig.servers.mainServer", notification)
				.mustNotBeNull("[BotConfig] Main server must be defined!");
		valid(mainServer.getId(), "BotConfig.servers.mainServer.id", notification)
				.must(ValidationUtil::isValidDiscordID, "ID of main server must be a valid Discord ID!");

		validateConfigServerTextChannels(mainServer, notification);

		validateConfigServerVoiceChannels(mainServer, notification);

		validateConfigServerRoles(mainServer, notification);

		BotConfigServer testServer = servers.getTestServer();
		valid(testServer, "BotConfig.servers.testServer", notification)
				.mustNotBeNull("[BotConfig] Test server must be defined!");
		valid(testServer.getId(), "BotConfig.servers.testServer.id", notification)
				.must(ValidationUtil::isValidDiscordID, "ID of test server must be a valid Discord ID!");

		validateConfigServerTextChannels(testServer, notification);

		validateConfigServerVoiceChannels(testServer, notification);

		validateConfigServerRoles(testServer, notification);
	}

	private void validateConfigServerTextChannels(@NotNull BotConfigServer server, Notification notification) {
		BotConfigServerTextChannels textChannels = server.getTextChannels();
		valid(textChannels, "BotConfig.servers.mainServer.textChannels", notification)
				.mustNotBeNull("[BotConfig] Text channels must be defined!");
		for (Field field : textChannels.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				DiscordTextChannelType discordTextChannelType = DiscordTextChannelType.fromKey(field.getName());
				valid(discordTextChannelType, "BotConfig.servers.mainServer.textChannels." + field.getName(), notification)
						.mustNotBeNull("[BotConfig] Text channel is of unknown type!");
				if (field.get(textChannels) == null) {
					LOGGER.warn("[BotConfig] Text channel " + discordTextChannelType.getKey() + " is not defined for server with id \"" + server.getId() + "\"!");
					continue;
				}
				valid(field.get(textChannels), "BotConfig.servers.mainServer.textChannels." + field.getName() + ".value", notification)
						.must(id -> ValidationUtil.isValidDiscordID((String) id), "[BotConfig] ID of text channel type \"" + field.getName() + "\" must be a valid Discord ID!");
			} catch (IllegalAccessException e) {
				LOGGER.error("[BotConfig] Failed to validate text channel \"" + field.getName() + "\"!", e);
				System.exit(1);
			}
		}
	}

	private void validateConfigServerVoiceChannels(@NotNull BotConfigServer server, Notification notification) {
		BotConfigServerVoiceChannels textChannels = server.getVoiceChannels();
		valid(textChannels, "BotConfig.servers.mainServer.voiceChannels", notification)
				.mustNotBeNull("[BotConfig] Voice channels must be defined!");
		for (Field field : textChannels.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				DiscordVoiceChannelType discordVoiceChannelType = DiscordVoiceChannelType.fromKey(field.getName());
				valid(discordVoiceChannelType, "BotConfig.servers.mainServer.voiceChannels." + field.getName(), notification)
						.mustNotBeNull("[BotConfig] Voice channel is of unknown type!");
				if (field.get(textChannels) == null) {
					continue;
				}
				valid(field.get(textChannels), "BotConfig.servers.mainServer.voiceChannels." + field.getName() + ".value", notification)
						.must(id -> ValidationUtil.isValidDiscordID((String) id), "[BotConfig] ID of voice channel type \"" + field.getName() + "\" must be a valid Discord ID!");
			} catch (IllegalAccessException e) {
				LOGGER.error("[BotConfig] Failed to validate voice channel \"" + field.getName() + "\"!", e);
				System.exit(1);
			}
		}
	}

	private void validateConfigServerRoles(@NotNull BotConfigServer server, Notification notification) {
		BotConfigServerRoles roles = server.getRoles();
		valid(roles, "BotConfig.servers.mainServer.roles", notification)
				.mustNotBeNull("[BotConfig] Roles must be defined!");
		for (Field field : roles.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			try {
				DiscordRoleType discordRoleType = DiscordRoleType.fromKey(field.getName());
				valid(discordRoleType, "BotConfig.servers.mainServer.roles." + field.getName(), notification)
						.mustNotBeNull("[BotConfig] Role is of unknown type!");
				if (field.get(roles) == null) {
					continue;
				}
				valid(field.get(roles), "BotConfig.servers.mainServer.roles." + field.getName() + ".value", notification)
						.must(id -> ValidationUtil.isValidDiscordID((String) id), "[BotConfig] ID of role type \"" + field.getName() + "\" must be a valid Discord ID!");
			} catch (IllegalAccessException e) {
				LOGGER.error("[BotConfig] Failed to validate role \"" + field.getName() + "\" of main server!", e);
				System.exit(1);
			}
		}
	}

	private void validateChecks(@NotNull List<BotConfigCheck> checks, Notification notification) {
		valid(checks, "BotConfig.checks", notification)
				.mustNotBeNull("[BotConfig] Checks must be defined!");

		for (BotConfigCheck check : checks) {
			valid(check.getName(), "BotConfig.checks." + check.getName() + ".name", notification)
					.mustNotBeNull("[BotConfig] Name of check must not be null!")
					.must(String::isBlank, "[BotConfig] Name of check must not be blank!");

			valid(check.getInterval(), "BotConfig.checks." + check.getName() + ".interval", notification)
					.must(interval -> interval > 10L, "[BotConfig] Interval of check \"" + check.getName() + "\" must be greater than 10 milliseconds!");
		}

		valid(checks, "BotConfig.checks[unique]", notification)
				.must(checksP -> checksP.stream().map(BotConfigCheck::getName).distinct().count() == checksP.size(), "[BotConfig] Checks must have unique names!");
	}

	private void validateCommands(@NotNull List<BotConfigCommand> commands, Notification notification) {
		valid(commands, "BotConfig.commands", notification)
				.mustNotBeNull("[BotConfig] Commands must be defined!");

		for (BotConfigCommand command : commands) {
			valid(command.getName(), "BotConfig.commands." + command.getName() + ".name", notification)
					.mustNotBeNull("[BotConfig] Name of command must not be null!")
					.must(String::isBlank, "[BotConfig] Name of command must not be blank!");

			valid(command.getDescription(), "BotConfig.commands." + command.getName() + ".description", notification)
					.mustNotBeNull("[BotConfig] Description of command must not be null!")
					.must(String::isBlank, "[BotConfig] Description of command must not be blank!");

			valid(command.getAliases(), "BotConfig.commands." + command.getName() + ".aliases", notification)
					.mustNotBeNull("[BotConfig] Aliases of command must not be null!")
					.must(aliases -> aliases.stream().anyMatch(String::isBlank), "[BotConfig] Aliases of command must not be blank!")
					.must(aliases -> aliases.stream().distinct().count() == aliases.size(), "[BotConfig] Aliases of command must be unique!");

			command.getArguments().forEach(commandArg -> validateCommandArgument(command, commandArg, notification));

			// TODO: Check for every commands aliases if they are unique to every command name

			List<String> allowedRoles = command.getAllowedRoles();
			if (allowedRoles != null) {
				valid(allowedRoles, "BotConfig.commands." + command.getName() + ".allowedRoles", notification)
						.mustNotBeNull("[BotConfig] Allowed roles of command must not be null!")
						.must(roles -> roles.stream().anyMatch(String::isBlank), "[BotConfig] Allowed roles of command must not be blank!")
						.must(roles -> roles.stream().distinct().count() == roles.size(), "[BotConfig] Allowed roles of command must be unique!")
						.must(roles -> roles.stream().map(DiscordRoleType::fromKey).anyMatch(Objects::isNull), "[BotConfig] Allowed roles of command must be valid Discord role types!");
			}

			List<String> allowedChannels = command.getAllowedChannels();
			if (allowedChannels != null) {
				valid(allowedChannels, "BotConfig.commands." + command.getName() + ".allowedChannels", notification)
						.mustNotBeNull("[BotConfig] Allowed channels of command must not be null!")
						.must(channels -> channels.stream().anyMatch(String::isBlank), "[BotConfig] Allowed channels of command must not be blank!")
						.must(channels -> channels.stream().distinct().count() == channels.size(), "[BotConfig] Allowed channels of command must be unique!")
						.must(channels -> channels.stream().map(DiscordTextChannelType::fromKey).anyMatch(Objects::isNull), "[BotConfig] Allowed channels of command must be valid Discord text channel types!");
			}
		}
	}

	private void validateCommandArgument(@NotNull BotConfigCommand command, @NotNull BotConfigCommandArgument argument, Notification notification) {
		valid(command, "BotConfig.commands." + command.getName() + ".arguments." + command.getName(), notification)
				.mustNotBeNull("[BotConfig] Command must not be null!");

		valid(argument.getName(), "BotConfig.commands." + command.getName() + ".arguments." + command.getName() + "." + argument.getName(), notification)
				.mustNotBeNull("[BotConfig] Name of argument must not be null!")
				.must(String::isBlank, "[BotConfig] Name of argument must not be blank!");

		valid(argument.getDescription(), "BotConfig.commands." + command.getName() + ".arguments." + command.getName() + "." + argument.getName() + ".description", notification)
				.mustNotBeNull("[BotConfig] Description of argument must not be null!")
				.must(String::isBlank, "[BotConfig] Description of argument must not be blank!");

		valid(argument.getDataType(), "BotConfig.commands." + command.getName() + ".arguments." + command.getName() + "." + argument.getName() + ".dataType", notification)
				.mustNotBeNull("[BotConfig] Data type of argument must not be null!")
				.must(String::isBlank, "[BotConfig] Data type of argument must not be blank!")
				.must(dataType -> DiscordCommandArgumentDataType.fromString(dataType) != null, "[BotConfig] Data type of argument must be valid Discord command argument data type!");

		// TODO Check default value is valid for data type
		// TODO Check if allowed values are not null that they are valid for data type
		// TODO Check that every argument name is unique
	}
}