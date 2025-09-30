package com.korona.file_organizer.controller;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.mapper.ManagerMapper;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.service.ComparatorFactory;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.writer.OutputWriter;
import com.korona.file_organizer.writer.impl.FileWriter;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class DepartmentWriterController {
    private final DepartmentService departmentService;
    private final Config config;

    public void writeDepartments() {
        departmentService.getAllDepartments()
                .forEach(this::writeDepartmentToFile);
    }

    private void writeDepartmentToFile(Department department) {
        Path path = buildFilePath(department.getDepartmentName());
        try (OutputWriter writer = new FileWriter(path)) {
            writer.writeLine(ManagerMapper.mapToString(department.getManager()));
            writeEmployees(writer, department.getEmployees());
        }
    }

    private void writeEmployees(OutputWriter writer, List<Employee> employees) {
        if (employees == null || employees.isEmpty()) {
            return;
        }

        List<Employee> sortedEmployees = new ArrayList<>(employees);

        ComparatorFactory.getComparator(config)
                .ifPresent(sortedEmployees::sort);

        sortedEmployees.stream()
                .map(EmployeeMapper::mapToString)
                .forEach(writer::writeLine);
    }

    private Path buildFilePath(String departmentName) {
        return config.getOutputDir().resolve(departmentName + config.getFileExtension());
    }
}
