package io.github.akjo03.genixbot.services.data;

import lombok.ToString;

@ToString
public enum BotDataServiceState {
	NOT_INITIALIZED,
	NEW_INITIALIZED,
	INITIALIZED,
	READY,
	SAVING;
}