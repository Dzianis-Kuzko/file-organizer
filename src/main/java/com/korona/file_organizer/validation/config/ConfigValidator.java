package com.korona.file_organizer.validation.config;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exceptions.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Validates a {@link Config} instance against a set of {@link ValidationRule}.
 */

@AllArgsConstructor
public class ConfigValidator {
    private final List<ValidationRule> rules;

    /**
     * Validates the given {@link Config} using all provided rules.
     *
     * @throws ValidationException if a validation rule fails
     */

    public void validate(Config config) {
        rules.forEach(rule -> rule.validate(config));
    }
}
