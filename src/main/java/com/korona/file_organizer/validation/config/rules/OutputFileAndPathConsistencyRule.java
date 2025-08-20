package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.OutputTypeForStats;
import com.korona.file_organizer.exceptions.ValidationException;

public class OutputFileAndPathConsistencyRule implements ValidationRule {
    @Override

    public void validate(Config config) throws ValidationException {
        boolean isOutputTypeFile  = config.getOutputType().getValue() == OutputTypeForStats.FILE;
        boolean hasPath = config.getOutputPath().getValue() != null;
        if (isOutputTypeFile  ^ hasPath) {
            throw new ValidationException("Если указан тип вывода FILE, обязательно должен быть задан путь к файлу, и наоборот.");
        }
    }
}
