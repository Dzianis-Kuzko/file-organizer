package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.repository.impl.EmployeeRepository;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public class EmployeeService implements Service<Employee> {
    private final EmployeeRepository employeeRepository;
    private final ManagerService managerService;

    @Override
    public Optional<Employee> add(Employee employee) {
        employeeRepository.add(employee);
        return Optional.of(employee);
    }

    public List<Employee> getEmployeesByManagerId(int managerId) {
        return employeeRepository.getEmployees(managerId);
    }


    public List<Employee> getSortedEmployees(int managerId, Comparator<Employee> comparator) {
        List<Employee> employees = getEmployeesByManagerId(managerId);
        employees.sort(comparator);
        return employees;
    }

    public List<Employee> getEmployeesWithoutManager() {
        return employeeRepository.getAllManagerIdsWithEmployees().stream()
                .filter(managerId -> !managerService.getAllManagerIds().contains(managerId))
                .flatMap(managerId -> employeeRepository.getEmployees(managerId).stream())
                .toList();
    }

    public Set<Integer> getAllManagerIdsWithEmployees() {
        return employeeRepository.getAllManagerIdsWithEmployees();
    }
}
