package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exceptions.ValidationException;

public class OutputFileAndPathOrderRule implements ValidationRule{
    @Override
    public void validate(Config config) throws ValidationException {
        Integer filePosition = config.getOutputType().getPosition();
        Integer pathPosition = config.getOutputPath().getPosition();

        if (filePosition != null && pathPosition != null) {
            if (pathPosition != filePosition + 1) {
                throw new ValidationException("Параметр пути должен идти сразу после параметра FILE.");
            }
        }
    }
}
