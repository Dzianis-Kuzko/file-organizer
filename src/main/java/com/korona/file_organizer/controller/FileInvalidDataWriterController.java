package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.FileWriter;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.mapper.InvalidDataMapper;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.service.impl.EmployeeService;
import com.korona.file_organizer.service.impl.InvalidDataService;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.List;

@AllArgsConstructor
public class FileInvalidDataWriterController {
    private final InvalidDataService invalidDataService;
    private final EmployeeService employeeService;

    public void writeInvalidData() {
        List<InvalidData> invalidDataList = invalidDataService.getAllInvalidData();


        Path path = buildFilePath(ProjectConstant.FILE_NANE_FOR_INVALID_DATA);
        try (FileWriter fileWriter = new FileWriter(path)) {
            writeInvalidData(fileWriter, invalidDataList);
        }

    }

    private Path buildFilePath(String fileName) {
        return Path.of(ProjectConstant.OUTPUT_FILES_DIR, fileName);
    }

    private void writeInvalidData(FileWriter fileWriter, List<InvalidData> invalidDataList) {

        for (InvalidData invalidData : invalidDataList) {
            fileWriter.writeLine(InvalidDataMapper.mapToString(invalidData));
        }

        List<Employee> employees = employeeService.getEmployeesWithoutManager();
        for (Employee employee : employees) {
            fileWriter.writeLine(EmployeeMapper.mapToString(employee));
        }
    }
}
