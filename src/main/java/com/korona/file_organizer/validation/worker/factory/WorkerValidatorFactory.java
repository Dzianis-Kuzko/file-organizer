package com.korona.file_organizer.validation.worker.factory;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.validation.Validator;
import com.korona.file_organizer.validation.worker.BaseWorkerValidator;
import com.korona.file_organizer.validation.worker.WorkerValidator;
import com.korona.file_organizer.validation.worker.rules.DepartmentNameValidationRule;
import com.korona.file_organizer.validation.worker.rules.SalaryValidationRule;
import com.korona.file_organizer.validation.worker.rules.WorkerNameValidationRule;

import java.util.Collections;
import java.util.List;

public class WorkerValidatorFactory {
    private WorkerValidatorFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static Validator<Manager> createManagerValidator() {
        return new WorkerValidator<Manager>(
                createBaseValidator(),
                List.of(new DepartmentNameValidationRule())
        );
    }

    public static Validator<Employee> createEmployeeValidator() {
        return new WorkerValidator<Employee>(
                createBaseValidator(),
                Collections.emptyList()
        );
    }

    private static BaseWorkerValidator createBaseValidator() {
        return new BaseWorkerValidator(List.of(
                new WorkerNameValidationRule(),
                new SalaryValidationRule()
        ));
    }
}
