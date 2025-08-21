package com.korona.file_organizer.validation.config.rules.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exceptions.ValidationException;
import com.korona.file_organizer.validation.config.rules.ValidationRule;

public class SortAndOrderConsistencyRule implements ValidationRule {
    @Override
    public void validate(Config config) {
        boolean hasSortBy = config.getSortBy() != null;
        boolean hasOrder = config.getOrder() != null;

        if (hasSortBy ^ hasOrder) {
            throw new ValidationException("Sorting type and order must be specified together or omitted");
        }
    }
}
