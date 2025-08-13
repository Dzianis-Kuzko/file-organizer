package com.korona.file_organizer.validation.rules;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.exceptions.ValidationException;

public class SortAndOrderConsistencyRule implements ValidationRule {
    @Override
    public void validate(Config config) throws ValidationException {
        boolean hasSortBy = config.getSortBy() != null;
        boolean hasOrder = config.getOrder() != null;

        if (hasSortBy ^ hasOrder) {
            throw new ValidationException("Параметры сортировки должны быть указаны вместе или отсутствовать.");
        }
    }
}
