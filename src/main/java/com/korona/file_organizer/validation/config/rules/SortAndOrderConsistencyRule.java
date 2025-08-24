package com.korona.file_organizer.validation.config.rules;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.validation.ValidationRule;

public class SortAndOrderConsistencyRule implements ValidationRule<Config> {
    @Override
    public void validate(Config config) {
        boolean hasSortBy = config.getSortBy() != null;
        boolean hasOrder = config.getOrder() != null;

        if (hasSortBy ^ hasOrder) {
            throw new ValidationException("Error. Sorting type and order must be specified together or omitted");
        }
    }
}
