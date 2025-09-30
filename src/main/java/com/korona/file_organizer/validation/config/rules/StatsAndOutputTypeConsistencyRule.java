package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.validation.ValidationRule;

public class StatsAndOutputTypeConsistencyRule implements ValidationRule<Config> {

    @Override
    public void validate(Config config) {
        boolean isStatEnabled = config.isStatEnabled();
        boolean isOutputTypeDefaulted = config.isOutputTypeForStatsDefaulted();

        if (!isStatEnabled && !isOutputTypeDefaulted) {
            throw new ValidationException(
                    "Error. The type of statistics output cannot be specified without enabling statistics.");
        }
    }
}
