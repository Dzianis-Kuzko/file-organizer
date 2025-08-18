package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.model.Department;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.InvalidDataService;
import com.korona.file_organizer.service.PendingDataService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FileDataLoadingController {
    private final FileFinder fileFinder;
    private final FileReader fileReader;
    private final LineParser lineParser;
    private final InvalidDataService invalidDataService;
    private final PendingDataService pendingDataService;
    private final DepartmentService departmentService;


    public void loadData() {

        fileFinder.findFiles(ProjectConstant.INPUT_FILES_DIR, ProjectConstant.FILE_EXTENSION)
                .stream()
                .flatMap(fileReader::readLines)
                .forEach(line -> lineParser.parse(line)
                        .ifPresentOrElse(
                                worker -> saveWorkerIfValid(worker, line),
                                () -> invalidDataService.add(new InvalidData(line))
                        )
                );


        List<Manager> managers = pendingDataService.getAllManagers();
        for (Manager manager : managers) {

            List<Employee> employees = pendingDataService.getEmployeesByManagerId(manager.getId());
            Department department = new Department(manager.getDepartmentName(), manager, employees);
            departmentService.add(department);

            pendingDataService.removeEmployeesByManagerId(manager.getId());

        }


        List<Employee> employeesWithoutManager = pendingDataService.getAllEmployees();
        for (Employee employee : employeesWithoutManager) {
            invalidDataService.add(new InvalidData((EmployeeMapper.mapToString(employee))));
        }

    }

    private void saveWorkerIfValid(Worker worker, String line) {
        if (worker instanceof Manager manager) {
            if (pendingDataService.addManager(manager).isEmpty()) {
                invalidDataService.add(new InvalidData(line));
            }
        } else if (worker instanceof Employee employee) {
            if (pendingDataService.addEmployee(employee).isEmpty()) {
                invalidDataService.add(new InvalidData(line));
            }
        }
    }
}
