package com.korona.file_organizer.service;

import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.DepartmentSalaryStats;
import com.korona.file_organizer.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


public class DepartmentStatsService {
    public DepartmentSalaryStats calculate(Department department) {
        List<Employee> employees = department.getEmployees();

        if (employees == null || employees.isEmpty()) {
            return new DepartmentSalaryStats(
                    department.getDepartmentName(),
                    BigDecimal.ZERO.setScale(2, RoundingMode.CEILING),
                    BigDecimal.ZERO.setScale(2, RoundingMode.CEILING),
                    BigDecimal.ZERO.setScale(2, RoundingMode.CEILING)
            );
        }

        BigDecimal firstSalary = employees.get(0).getSalary();
        BigDecimal min = firstSalary;
        BigDecimal max = firstSalary;
        BigDecimal sum = firstSalary;

        for (int i = 1; i < employees.size(); i++) {
            BigDecimal salary = employees.get(i).getSalary();

            if (salary.compareTo(min) < 0) {
                min = salary;
            }
            if (salary.compareTo(max) > 0) {
                max = salary;
            }

            sum = sum.add(salary);
        }

        BigDecimal mid = sum.divide(BigDecimal.valueOf(employees.size()), 2, RoundingMode.CEILING);

        return new DepartmentSalaryStats(
                department.getDepartmentName(),
                min.setScale(2, RoundingMode.CEILING),
                max.setScale(2, RoundingMode.CEILING),
                mid.setScale(2, RoundingMode.CEILING)
        );
    }

}

