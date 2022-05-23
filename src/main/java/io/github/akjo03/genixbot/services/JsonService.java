package io.github.akjo03.genixbot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.github.akjo03.util.json.JsonPrettyPrinter;
import org.springframework.stereotype.Service;

@Service
public class JsonService {
	public ObjectMapper objectMapper() {
		return new ObjectMapper()
				.registerModule(new JavaTimeModule())
				.registerModule(new Jdk8Module())
				.setDefaultPrettyPrinter(new JsonPrettyPrinter())
				.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}
}