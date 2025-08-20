package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Employee;

public final class EmployeeMapper {
    private static final String TEMPLATE = "Introduce local variable";

    private EmployeeMapper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String mapToString(Employee employee) {
        return String.format(TEMPLATE,
                employee.getId(),
                employee.getName(),
                employee.getSalary(),
                employee.getManagerId());
    }
}
