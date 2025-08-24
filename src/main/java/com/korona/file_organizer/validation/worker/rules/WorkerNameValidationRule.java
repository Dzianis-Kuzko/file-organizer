package com.korona.file_organizer.validation.worker.rules;

import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.validation.ValidationRule;

public class WorkerNameValidationRule implements ValidationRule<Worker> {
    @Override
    public void validate(Worker worker) {
        if (worker.getName() == null || !worker.getName().matches("^[A-Za-zА-Яа-я\\s]+$")) {
            throw new ValidationException("Invalid worker name: " + worker.getName());
        }
    }
}
