package com.korona.file_organizer.validation.config.factory;

import com.korona.file_organizer.validation.config.rules.ValidationRule;
import com.korona.file_organizer.validation.config.rules.impl.OutputFileForStatsAndPathConsistencyRule;
import com.korona.file_organizer.validation.config.rules.impl.OutputFileForStatsAndPathOrderRule;
import com.korona.file_organizer.validation.config.rules.impl.OutputPathForStatsValidationRule;
import com.korona.file_organizer.validation.config.rules.impl.SortAndOrderConsistencyRule;
import com.korona.file_organizer.validation.config.rules.impl.StatsAndOutputTypeConsistencyRule;

import java.util.List;

public final class ConfigValidatorFactory {
    private ConfigValidatorFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static List<ValidationRule> createRules() {
        return List.of(
                new SortAndOrderConsistencyRule(),
                new StatsAndOutputTypeConsistencyRule(),
                new OutputFileForStatsAndPathConsistencyRule(),
                new OutputFileForStatsAndPathOrderRule(),
                new OutputPathForStatsValidationRule()
        );
    }
}
