package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.validation.ValidationRule;

public class OutputFileForStatsAndPathOrderRule implements ValidationRule<Config> {
    @Override
    public void validate(Config config) {
        Integer fileOutputTypePosition = config.getOutputTypeForStats().getPosition();
        Integer pathPosition = config.getOutputPathForStats().getPosition();

        if (fileOutputTypePosition != null && pathPosition != null && pathPosition != fileOutputTypePosition + 1) {
            throw new ValidationException("Error. The output path parameter must immediately " +
                    "follow the output type (file) parameter");
        }
    }
}

