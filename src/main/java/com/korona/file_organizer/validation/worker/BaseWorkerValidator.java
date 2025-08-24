package com.korona.file_organizer.validation.worker;

import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.validation.ValidationRule;
import com.korona.file_organizer.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BaseWorkerValidator implements Validator<Worker> {
    private final List<ValidationRule<? super Worker>> rules;

    @Override
    public void validate(Worker worker) {
        rules.forEach(rule -> rule.validate(worker));
    }
}
