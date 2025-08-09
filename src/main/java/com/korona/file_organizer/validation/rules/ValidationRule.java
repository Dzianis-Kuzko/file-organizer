package com.korona.file_organizer.validation.rules;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.validation.ValidationException;

public interface ValidationRule {
    void validate(Config config) throws ValidationException;
}
