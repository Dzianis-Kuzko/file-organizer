package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Department {
    private String departmentName;
    private Manager manager;
    private List<Employee> employees;
}
