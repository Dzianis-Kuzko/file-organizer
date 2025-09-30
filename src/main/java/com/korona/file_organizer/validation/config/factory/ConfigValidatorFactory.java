package com.korona.file_organizer.validation.config.factory;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.validation.ValidationRule;
import com.korona.file_organizer.validation.config.rules.OutputFileForStatsAndPathConsistencyRule;
import com.korona.file_organizer.validation.config.rules.OutputFileForStatsAndPathOrderRule;
import com.korona.file_organizer.validation.config.rules.OutputPathForStatsValidationRule;
import com.korona.file_organizer.validation.config.rules.SortAndOrderConsistencyRule;
import com.korona.file_organizer.validation.config.rules.StatsAndOutputTypeConsistencyRule;

import java.util.List;

public final class ConfigValidatorFactory {
    private ConfigValidatorFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static List<ValidationRule<Config>> createRules() {
        return List.of(
                new SortAndOrderConsistencyRule(),
                new StatsAndOutputTypeConsistencyRule(),
                new OutputFileForStatsAndPathConsistencyRule(),
                new OutputFileForStatsAndPathOrderRule(),
                new OutputPathForStatsValidationRule()
        );
    }
}
