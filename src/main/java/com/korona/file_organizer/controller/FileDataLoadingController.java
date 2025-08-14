package com.korona.file_organizer.controller;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.LineParser;
import com.korona.file_organizer.service.Service;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FileDataLoadingController {
    private final FileFinder fileFinder;
    private final FileReader fileReader;
    private final LineParser lineParser;
    private final Service<Employee> employeeService;
    private final Service<Manager> managerService;
    private final Service<String> invalidDataService;


    public void loadData() {
        fileFinder.findFiles(ProjectConstant.INPUT_FILES_DIR, ProjectConstant.FILE_EXTENSION)
                .stream()
                .flatMap(fileReader::readLines)
                .forEach(line -> lineParser.parse(line)
                        .ifPresentOrElse(
                                worker -> saveWorkerIfValid(worker, line),
                                () -> invalidDataService.add(line)
                        )
                );
    }

    private void saveWorkerIfValid(Worker worker, String line) {
        if (worker instanceof Manager manager) {
            if (managerService.add(manager).isEmpty()) {
                invalidDataService.add(line);
            }
        } else if (worker instanceof Employee employee) {
            if (employeeService.add(employee).isEmpty()) {
                invalidDataService.add(line);
            }
        }
    }
}
