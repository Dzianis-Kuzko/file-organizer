package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.writer.impl.FileWriter;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.mapper.ManagerMapper;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.service.ComparatorFactory;
import com.korona.file_organizer.service.DepartmentService;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
public class FileDepartmentWriterController {
    private final DepartmentService departmentService;
    private final ComparatorFactory comparatorFactory;
    private final Config config;

    public void writeDepartment() {
        List<Department> departments = departmentService.getAllDepartments();
        for (Department department : departments) {
            Path path = buildFilePath(department.getDepartmentName());
            try (FileWriter fileWriter = new FileWriter(path)) {
                writeDepartmentContent(fileWriter, department);
            }

        }

    }

    private Path buildFilePath(String departmentName) {
        return Path.of(ProjectConstant.OUTPUT_FILES_DIR, departmentName + ".sb");
    }

    private void writeDepartmentContent(FileWriter fileWriter, Department department) {

        // сам менеджер
        fileWriter.writeLine(ManagerMapper.mapToString(department.getManager()));

        // сотрудники
        List<Employee> employees = department.getEmployees();
        if (employees != null) {
            if (config.getSortBy() != null) {
                Comparator<Employee> comparator = comparatorFactory.getComparator(config);
                employees.sort(comparator);
            }

            for (Employee employee : employees) {
                fileWriter.writeLine(EmployeeMapper.mapToString(employee));
            }
        }

    }
}
