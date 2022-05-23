package io.github.akjo03.genixbot.model.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuppressWarnings("unused")
public class BotConfigCommandArgument {
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

	public BotConfigCommandArgument(
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