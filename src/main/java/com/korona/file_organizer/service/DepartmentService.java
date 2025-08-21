package com.korona.file_organizer.service;

import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.repository.DepartmentRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public void add(Department department) {
        departmentRepository.add(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

}
