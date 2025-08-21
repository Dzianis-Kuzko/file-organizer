package com.korona.file_organizer.validation.config.rules.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exceptions.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

public class StatsAndOutputTypeConsistencyRule implements ValidationRule {

    @Override
    public void validate(Config config) {
        boolean isStatEnabled = config.isStatEnabled();
        boolean isOutputTypeDefaulted = config.isOutputTypeForStatsDefaulted();

        if (!isStatEnabled && !isOutputTypeDefaulted) {
            throw new ValidationException(
                    "The type of statistics output cannot be specified without enabling statistics.");
        }
    }
}
