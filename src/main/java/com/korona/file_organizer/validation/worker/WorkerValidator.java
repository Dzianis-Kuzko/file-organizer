package com.korona.file_organizer.validation.worker;

import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.validation.ValidationRule;
import com.korona.file_organizer.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class WorkerValidator<T extends Worker> implements Validator<T> {
    private final BaseWorkerValidator baseWorkerValidator;
    private final List<ValidationRule<? super T>> workerSpecificRules;

    @Override
    public void validate(T worker) {
        baseWorkerValidator.validate(worker);
        workerSpecificRules.forEach(rule -> rule.validate(worker));
    }
}