package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.validation.ValidationRule;

import java.nio.file.Path;

public class OutputPathForStatsValidationRule implements ValidationRule<Config> {
    @Override
    public void validate(Config config) {
        Path outputPathForStats = config.getOutputPathForStats().getValue();
        if (outputPathForStats == null) {
            return;
        }

        if (!hasFileExtension(outputPathForStats.getFileName().toString())) {
            throw new ValidationException("Error. The path was specified incorrectly: " + outputPathForStats);
        }
    }

    private boolean hasFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        return lastDotIndex > 0 && lastDotIndex < fileName.length() - 1;
    }
}
