package io.github.akjo03.genixbot.model.validation;

import io.github.akjo03.util.math.Range;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ValidationUtil {
	public boolean isValidDiscordID(String discordID) {
		if (discordID == null) {
			return false;
		}

		if (!new Range<>(5, 19).contains(discordID.length())) {
			return false;
		}

		try { Integer.parseInt(discordID); } catch (NumberFormatException e) {
			return false;
		}

		return true;
	}
}