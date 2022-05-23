package io.github.akjo03.genixbot.model.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotDataCommandArgument {
	@JsonSerialize
	@JsonDeserialize
	@EqualsAndHashCode.Include
	private String name;

	@JsonSerialize
	@JsonDeserialize
	private String description;

	@JsonSerialize
	@JsonDeserialize
	private boolean required;

	@JsonSerialize
	@JsonDeserialize
	private String dataType;

	@JsonSerialize
	@JsonDeserialize
	private String defaultValue;

	@JsonSerialize
	@JsonDeserialize
	private List<String> allowedValues;

	@JsonCreator
	public BotDataCommandArgument(
			@JsonProperty("name") String name,
			@JsonProperty("description") String description,
			@JsonProperty("required") boolean required,
			@JsonProperty("dataType") String dataType,
			@JsonProperty("defaultValue") String defaultValue,
			@JsonProperty("allowedValues") List<String> allowedValues
	) {
		this.name = name;
		this.description = description;
		this.required = required;
		this.dataType = dataType;
		this.defaultValue = defaultValue;
		this.allowedValues = allowedValues;
	}
}