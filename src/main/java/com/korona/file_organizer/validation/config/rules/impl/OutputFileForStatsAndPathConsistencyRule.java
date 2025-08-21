package com.korona.file_organizer.validation.config.rules.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.impl.OutputTypeForStats;
import com.korona.file_organizer.exceptions.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

public class OutputFileForStatsAndPathConsistencyRule implements ValidationRule {

    @Override
    public void validate(Config config) {
        boolean isOutputTypeFile = config.getOutputTypeForStats().getValue() == OutputTypeForStats.FILE;
        boolean hasPath = config.getOutputPathForStats().getValue() != null;

        if (isOutputTypeFile ^ hasPath) {
            throw new ValidationException("If the output type is file," +
                    " an output path must be specified, and vice versa.");
        }
    }
}
