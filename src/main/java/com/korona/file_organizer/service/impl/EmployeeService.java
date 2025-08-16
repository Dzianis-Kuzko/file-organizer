package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.repository.impl.EmployeeRepository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EmployeeService implements Service<Employee> {
    private final EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> add(Employee employee) {
        employeeRepository.add(employee);
        return Optional.of(employee);
    }

    public List<Employee> getEmployees(int managerId) {
        return employeeRepository.getEmployees(managerId);
    }


    public List<Employee> getSortedEmployees(int managerId, Comparator<Employee> comparator) {
        List<Employee> employees = getEmployees(managerId);
        employees.sort(comparator);
        return employees;
    }
}
