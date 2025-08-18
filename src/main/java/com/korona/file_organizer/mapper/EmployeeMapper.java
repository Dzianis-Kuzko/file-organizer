package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Employee;

public class EmployeeMapper {
    public static String mapToString(Employee employee) {
        return String.format("Employee,%d,%s,%s,%d",
                employee.getId(),
                employee.getName(),
                employee.getSalary(),
                employee.getManagerId());
    }
}
