package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class DepartmentSalaryStats {
    private String departmentName;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal mid;
}
