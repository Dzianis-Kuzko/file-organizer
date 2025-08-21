package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Employee;

import java.math.BigDecimal;

public final class EmployeeMapper {
    private static final String TEMPLATE = "Employee,%d,%s,%s,%d";

    private EmployeeMapper() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static String mapToString(Employee employee) {
        return String.format(TEMPLATE,
                employee.getId(),
                employee.getName(),
                employee.getSalary(),
                employee.getManagerId());
    }

    public static Employee mapToEmployee(String[] parts) {
        int id = Integer.parseInt(parts[1]);
        String name = parts[2];
        BigDecimal salary = new BigDecimal(parts[3]);
        int managerId = Integer.parseInt(parts[4]);
        return new Employee(id, name, salary, managerId);
    }
}
