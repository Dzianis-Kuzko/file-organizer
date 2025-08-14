package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.repository.Repository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class EmployeeService implements Service<Employee> {
    private final Repository<Employee> repository;

    @Override
    public Optional<Employee> add(Employee employee) {
        repository.add(employee);
        return Optional.of(employee);
    }
}
