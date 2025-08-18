package com.korona.file_organizer.validation.config.factory;

import com.korona.file_organizer.validation.config.rules.OutputFileAndPathConsistencyRule;
import com.korona.file_organizer.validation.config.rules.OutputFileAndPathOrderRule;
import com.korona.file_organizer.validation.config.rules.SortAndOrderConsistencyRule;
import com.korona.file_organizer.validation.config.rules.StatAndOutputTypeConsistencyRule;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

import java.util.List;

public class ConfigValidatorFactory {
    public List<ValidationRule> createRules() {
        return List.of(
                new SortAndOrderConsistencyRule(),
                new StatAndOutputTypeConsistencyRule(),
                new OutputFileAndPathConsistencyRule(),
                new OutputFileAndPathOrderRule()
        );
    }
}
