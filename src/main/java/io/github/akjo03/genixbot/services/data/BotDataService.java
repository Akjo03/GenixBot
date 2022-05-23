package io.github.akjo03.genixbot.services.data;

import com.fasterxml.jackson.databind.ObjectReader;
import io.github.akjo03.genixbot.model.data.BotData;
import io.github.akjo03.genixbot.services.JsonService;
import io.github.akjo03.genixbot.util.GenixBotConstants;
import io.github.akjo03.util.ProjectDirectory;
import io.github.akjo03.util.logging.v2.Logger;
import io.github.akjo03.util.logging.v2.LoggerManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
@RequiredArgsConstructor
public class BotDataService {
	private final Logger LOGGER = LoggerManager.getLogger(BotDataService.class, GenixBotConstants.LOGGING_LEVEL);
	@Getter
	private final Path botDataPath = Path.of(String.valueOf(ProjectDirectory.getUsersProjectRootDirectory()), "data", "bot_data.json");


	@Getter
	private BotDataServiceState state = BotDataServiceState.NOT_INITIALIZED;

	@Getter
	private BotData botData;
	private ObjectReader botDataReader;

	private final JsonService jsonService;

	@Bean
	public BotData createBotData() {
		try {
			createBotDataFileIfNotExists(() -> {
				LOGGER.info("Filling bot data file with default values...");

				BotData botData = new BotData();

				try {
					jsonService.objectMapper().writeValue(botDataPath.toFile(), botData);
				} catch (IOException e) {
					LOGGER.error("Failed to write bot data to file!", e);
					System.exit(1);
				}

				this.botData = botData;
				this.botDataReader = jsonService.objectMapper().readerForUpdating(botData);

				LOGGER.success("Successfully filled bot data file with default values!");
				this.state = BotDataServiceState.NEW_INITIALIZED;
			}, () -> {
				LOGGER.info("Reading bot data from file...");
			});
		} catch (IOException e) {
			LOGGER.error("Failed to create bot data file!", e);
			System.exit(1);
		}
		return null;
	}

	private void createBotDataFileIfNotExists(Runnable onCreated, Runnable onExists) throws IOException {
		if (Files.exists(botDataPath)) {
			LOGGER.info("Bot data file already exists!");
			onExists.run();
			return;
		}

		LOGGER.info("Creating bot data file...");

		Files.createDirectories(botDataPath.getParent());
		Files.createFile(botDataPath);

		LOGGER.success("Successfully created bot data file!");

		onCreated.run();
	}
}