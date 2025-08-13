package com.korona.file_organizer.repository;

import com.korona.file_organizer.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {
    private final Map<Integer, List<Employee>> employees = new HashMap<>();
}
