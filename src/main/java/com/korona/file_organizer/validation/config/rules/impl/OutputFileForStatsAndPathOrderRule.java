package com.korona.file_organizer.validation.config.rules.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exceptions.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

public class OutputFileForStatsAndPathOrderRule implements ValidationRule {
    @Override
    public void validate(Config config){
        Integer filePosition = config.getOutputTypeForStats().getPosition();
        Integer pathPosition = config.getOutputPathForStats().getPosition();

        if (filePosition != null && pathPosition != null && pathPosition != filePosition + 1) {
            throw new ValidationException("The output path parameter must immediately " +
                    "follow the output type (file) parameter");
        }
    }
}

