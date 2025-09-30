package com.korona.file_organizer.repository;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PendingDataRepository {
    private final Map<Integer, List<Employee>> employeesByManagerId = new HashMap<>();
    private final List<Manager> managers = new ArrayList<>();

    public void addEmployee(Employee employee) {
        employeesByManagerId.computeIfAbsent(employee.getManagerId(), k -> new ArrayList<>())
                .add(employee);
    }

    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public List<Manager> getAllManagers() {
        return managers;
    }

    public List<Employee> getEmployeesByManagerId(Integer managerId) {
        return employeesByManagerId.get(managerId);
    }

    public void removeEmployeesByManagerId(int managerId) {
        employeesByManagerId.remove(managerId);
    }

    public List<Employee> getAllEmployees() {
        return employeesByManagerId.values().stream()
                .flatMap(List::stream)
                .toList();
    }
}