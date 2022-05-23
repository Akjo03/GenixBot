package io.github.akjo03.genixbot.model.util;

import lombok.ToString;

@ToString
public enum DiscordCommandArgumentDataType {
	STRING,
	INT,
	FLOAT,
	BOOLEAN,
	USER,
	CHANNEL,
	ROLE,
	LINK,
	TIMESTAMP;

	public static DiscordCommandArgumentDataType fromString(String type) {
		return switch (type) {
			case "string" -> STRING;
			case "int" -> INT;
			case "float" -> FLOAT;
			case "boolean" -> BOOLEAN;
			case "user" -> USER;
			case "channel" -> CHANNEL;
			case "role" -> ROLE;
			case "link" -> LINK;
			case "timestamp" -> TIMESTAMP;
			default -> null;
		};
	}
}