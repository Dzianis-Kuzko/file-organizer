package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class DepartmentService {
    private final ManagerService managerService;
    private final EmployeeService employeeService;
    private final Config config;

    public Department getDepartmentByManager(Manager manager) {
        Comparator<Employee> comparator = ComparatorFactory.getComparator(config);
        List<Employee> employees;

        if(comparator==null){
            employees=employeeService.getEmployeesByManagerId(manager.getId());
        }else {
            employees=employeeService.getSortedEmployees(manager.getId(), comparator);
        }
        return new Department(manager.getDepartmentName(), manager, employees);
    }

}
