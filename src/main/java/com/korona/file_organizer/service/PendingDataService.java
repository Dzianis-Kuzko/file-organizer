package com.korona.file_organizer.service;

import com.korona.file_organizer.exception.ValidationException;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.repository.PendingDataRepository;
import com.korona.file_organizer.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PendingDataService {
    private final PendingDataRepository pendingDataRepository;
    private final Validator<Manager> managerValidator;
    private final Validator<Employee> employeeValidator;

    public Optional<Employee> addEmployee(Employee employee) {
        try {
            employeeValidator.validate(employee);
            pendingDataRepository.addEmployee(employee);
            return Optional.of(employee);
        } catch (ValidationException e) {
            return Optional.empty();
        }
    }

    public Optional<Manager> addManager(Manager manager) {
        try {
            managerValidator.validate(manager);
            pendingDataRepository.addManager(manager);
            return Optional.of(manager);
        } catch (ValidationException e) {
            return Optional.empty();
        }
    }

    public List<Manager> getAllManagers() {
        return pendingDataRepository.getAllManagers();
    }

    public List<Employee> getEmployeesByManagerId(Integer managerId) {
        return pendingDataRepository.getEmployeesByManagerId(managerId);
    }

    public void removeEmployeesByManagerId(int managerId) {
        pendingDataRepository.removeEmployeesByManagerId(managerId);
    }

    public List<Employee> getAllEmployees() {
        return pendingDataRepository.getAllEmployees();
    }

}
