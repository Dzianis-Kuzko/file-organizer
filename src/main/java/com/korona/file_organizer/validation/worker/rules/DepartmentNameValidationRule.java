package com.korona.file_organizer.validation.worker.rules;

import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.validation.ValidationRule;

public class DepartmentNameValidationRule implements ValidationRule<Manager> {

    @Override
    public void validate(Manager manager) {
        if (manager.getDepartmentName() == null || !manager.getDepartmentName().matches("^[A-Za-zА-Яа-я\\s]+$")) {
            throw new ValidationException("Invalid department name: " + manager.getDepartmentName());
        }
    }
}
