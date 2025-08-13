package com.korona.file_organizer.validation.rules;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.exceptions.ValidationException;

public class StatAndOutputTypeConsistencyRule implements ValidationRule {

    @Override
    public void validate(Config config) throws ValidationException {
        boolean isStatEnabled = config.isStatEnabled();
        boolean isOutputTypeDefaulted = config.isOutputTypeDefaulted();

        if (!isStatEnabled && !isOutputTypeDefaulted) {
            throw new ValidationException(
                    String.format("Выбран тип вывода \"%s\", но режим статистики отключён", config.getOutputType().getValue())
            );
        }
    }
}
