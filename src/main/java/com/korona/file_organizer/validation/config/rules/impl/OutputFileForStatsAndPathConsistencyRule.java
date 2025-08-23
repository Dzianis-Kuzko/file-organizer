package com.korona.file_organizer.validation.config.rules.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.impl.OutputTypeForStats;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

public class OutputFileForStatsAndPathConsistencyRule implements ValidationRule {

    @Override
    public void validate(Config config) {
        boolean isOutputTypeFile = config.getOutputTypeForStats().getValue() == OutputTypeForStats.FILE;
        boolean hasPath = config.getOutputPathForStats().getValue() != null;

        if (isOutputTypeFile ^ hasPath) {
            throw new ValidationException("Error. The output type is file and the output path " +
                    "must be specified together or omitted.");
        }
    }
}
