package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@SuppressWarnings("unused")
public class BotData {
	@JsonSerialize
	@JsonDeserialize
	private List<BotDataServer> servers;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataCheck> checks;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataListener> listeners;

	@JsonSerialize
	@JsonDeserialize
	private List<BotDataCommand> commands;


}