package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.DepartmentSalaryStats;

public class DepartmentSalaryStatsMapper {
    public static String mapToString(DepartmentSalaryStats departmentSalaryStats) {
        return String.format("%s, %.2f, %.2f, %.2f",
                departmentSalaryStats.getDepartmentName(),
                departmentSalaryStats.getMin(),
                departmentSalaryStats.getMax(),
                departmentSalaryStats.getMid());
    }
}
