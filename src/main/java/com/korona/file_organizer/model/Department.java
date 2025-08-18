package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Department {
    private String departmentName;
    private  Manager manager;
    private List<Employee> employees;
}
