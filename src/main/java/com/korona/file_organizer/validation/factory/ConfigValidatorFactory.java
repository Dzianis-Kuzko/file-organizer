package com.korona.file_organizer.validation.factory;

import com.korona.file_organizer.validation.rules.OutputFileAndPathConsistencyRule;
import com.korona.file_organizer.validation.rules.OutputFileAndPathOrderRule;
import com.korona.file_organizer.validation.rules.SortAndOrderConsistencyRule;
import com.korona.file_organizer.validation.rules.StatAndOutputTypeConsistencyRule;
import com.korona.file_organizer.validation.rules.ValidationRule;

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
