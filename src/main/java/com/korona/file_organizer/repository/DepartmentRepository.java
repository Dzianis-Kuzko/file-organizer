package com.korona.file_organizer.repository;

import com.korona.file_organizer.model.Department;

import java.util.ArrayList;
import java.util.List;


public class DepartmentRepository {
    private final List<Department> departments = new ArrayList<>();


    public void add(Department department) {
        departments.add(department);
    }

    public List<Department> getAllDepartments() {
        return departments;
    }
}
