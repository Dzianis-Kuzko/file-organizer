package com.korona.file_organizer.service;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.repository.PendingDataRepository;
import com.korona.file_organizer.validation.SalaryValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class PendingDataService {
    private final PendingDataRepository pendingDataRepository;
    private final SalaryValidator salaryValidator;

    public Optional<Employee> addEmployee(Employee employee) {
        if (salaryValidator.isValid(employee.getSalary())) {
            pendingDataRepository.addEmployee(employee);
            return Optional.of(employee);
        }
        return Optional.empty();
    }

    public Optional<Manager> addManager(Manager manager) {
        if (salaryValidator.isValid(manager.getSalary())) {
            pendingDataRepository.addManager(manager);
            return Optional.of(manager);
        }
        return Optional.empty();
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
