package com.korona.file_organizer.repository.impl;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.repository.Repository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class EmployeeRepository implements Repository<Employee> {
    private final Map<Integer, List<Employee>> employeesByManagerId = new HashMap<>();

    @Override
    public void add(Employee employee) {
        employeesByManagerId.computeIfAbsent(employee.getManagerId(), k -> new ArrayList<>()).add(employee);
    }

    public List<Employee> getEmployees(int managerId) {
        return new ArrayList<>(
                employeesByManagerId.getOrDefault(managerId, new ArrayList<>())
        );
    }
}
