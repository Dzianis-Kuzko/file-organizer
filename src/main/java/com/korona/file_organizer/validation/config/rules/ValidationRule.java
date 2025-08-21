package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;

/**
 * Defines a contract for validating {@link Config} instance.
 */

public interface ValidationRule {

    /**
     * Validates the provided configuration against this rule's criteria.
     *
     * @param config the configuration to validate; must not be null
     * @throws ValidationException if the configuration fails validation
     */

    void validate(Config config);
}
