package com.korona.file_organizer.validation.worker.rules;

import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.validation.ValidationRule;

import java.math.BigDecimal;

public class SalaryValidationRule implements ValidationRule<Worker> {
    @Override
    public void validate(Worker worker) {
        if (worker.getSalary() == null || worker.getSalary().compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValidationException("Invalid worker salary: " + worker.getSalary());
        }
    }
}
