package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.DepartmentSalaryStats;

public final class DepartmentSalaryStatsMapper {
    private static final String TEMPLATE = "%s, %.2f, %.2f, %.2f";

    private DepartmentSalaryStatsMapper() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }


    public static String mapToString(DepartmentSalaryStats departmentSalaryStats) {
        return String.format(TEMPLATE,
                departmentSalaryStats.getDepartmentName(),
                departmentSalaryStats.getMin(),
                departmentSalaryStats.getMax(),
                departmentSalaryStats.getMid());
    }
}
