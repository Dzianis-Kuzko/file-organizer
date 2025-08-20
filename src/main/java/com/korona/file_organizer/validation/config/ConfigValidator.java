package com.korona.file_organizer.validation.config;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

import java.util.List;

public class ConfigValidator {
    private final List<ValidationRule> rules;

    public ConfigValidator(List<ValidationRule> rules) {
        this.rules = rules;
    }

    public void validate(Config config) {
        for (ValidationRule rule : rules) {
            rule.validate(config);
        }
    }
}
