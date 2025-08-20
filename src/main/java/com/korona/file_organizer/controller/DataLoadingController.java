package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.reader.FileFinder;
import com.korona.file_organizer.reader.FileReader;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.InvalidDataService;
import com.korona.file_organizer.service.PendingDataService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DataLoadingController {
    private final FileFinder fileFinder;
    private final FileReader fileReader;
    private final LineParser lineParser;
    private final InvalidDataService invalidDataService;
    private final PendingDataService pendingDataService;
    private final DepartmentService departmentService;

    public void loadData() {
        loadWorkers();
        buildDepartments();
        handleEmployeesWithoutManagers();
    }

    private void loadWorkers() {
        fileFinder.findFiles(ProjectConstant.INPUT_FILES_DIR, ProjectConstant.FILE_EXTENSION)
                .stream()
                .flatMap(fileReader::readLines)
                .forEach(this::processLine);
    }

    private void processLine(String line) {
        lineParser.parse(line)
                .ifPresentOrElse(
                        worker -> {
                            boolean added = saveWorker(worker);
                            if (!added) {
                                invalidDataService.add(new InvalidData(line));
                            }
                        },
                        () -> invalidDataService.add(new InvalidData(line))
                );
    }

    private boolean saveWorker(Worker worker) {
        if (worker instanceof Manager manager) {
            return pendingDataService.addManager(manager).isPresent();
        } else if (worker instanceof Employee employee) {
            return pendingDataService.addEmployee(employee).isPresent();
        }
        return false;
    }

    private void buildDepartments() {
        pendingDataService.getAllManagers().forEach(manager -> {
            List<Employee> employees = pendingDataService.getEmployeesByManagerId(manager.getId());
            departmentService.add(new Department(manager.getDepartmentName(), manager, employees));
            pendingDataService.removeEmployeesByManagerId(manager.getId());
        });
    }

    private void handleEmployeesWithoutManagers() {
        pendingDataService.getAllEmployees().stream()
                .map(EmployeeMapper::mapToString)
                .map(InvalidData::new)
                .forEach(invalidDataService::add);
    }
}
