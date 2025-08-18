package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.FileWriter;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.mapper.ManagerMapper;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.service.impl.DepartmentService;
import com.korona.file_organizer.service.impl.ManagerService;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
public class FileDepartmentWriterController {
    private final DepartmentService departmentService;
    private final ManagerService managerService;

    public void writeDepartment() {
        List<Manager> managers = managerService.getAllManagers();
        for (Manager manager : managers) {
            Department department = departmentService.getDepartmentByManager(manager);
            Path path = buildFilePath(department.getName());
            try (FileWriter fileWriter = new FileWriter(path)) {
                writeDepartmentContent(fileWriter, department);
            }

        }

    }

    private Path buildFilePath(String departmentName) {
        return Path.of(ProjectConstant.OUTPUT_FILES_DIR, departmentName + ".sb");
    }

    private void writeDepartmentContent(FileWriter fileWriter, Department department) {
        // название департамента
        fileWriter.writeLine(department.getName());

        // сам менеджер
        fileWriter.writeLine(ManagerMapper.mapToString(department.getManager()));

        // сотрудники
        for (Employee employee : department.getEmployees()) {
            fileWriter.writeLine(EmployeeMapper.mapToString(employee));
        }
    }
}
