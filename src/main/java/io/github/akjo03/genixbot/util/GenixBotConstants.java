package io.github.akjo03.genixbot.util;

import io.github.akjo03.util.logging.v2.LoggingLevel;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GenixBotConstants {
	public final String BOT_NAME = "GenixBot";

	public final boolean DEBUG = true;
	public final boolean TESTING = true;

	public final LoggingLevel LOGGING_LEVEL = DEBUG ? LoggingLevel.DEBUG : LoggingLevel.INFO;
}