package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
public class DepartmentSalaryStats {
    private String departmentName;
    private BigDecimal min;
    private BigDecimal max;
    private BigDecimal mid;
}
