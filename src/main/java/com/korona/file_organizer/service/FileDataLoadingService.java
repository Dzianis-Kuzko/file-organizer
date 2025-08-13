package com.korona.file_organizer.service;

import com.korona.file_organizer.constant.ProjectConstant;
import com.korona.file_organizer.file.FileFinder;
import com.korona.file_organizer.file.FileReader;
import com.korona.file_organizer.model.DepartmentsData;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.InvalidData;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.LineParser;
import lombok.AllArgsConstructor;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class FileDataLoadingService {
    private final FileFinder fileFinder;
    private final FileReader fileReader;
    private final LineParser lineParser;


    public void loadAndValidateData() {
        List<Path> files = fileFinder.findFiles(ProjectConstant.INPUT_FILES_DIR, ProjectConstant.FILE_EXTENSION);
        files.forEach(file -> {
            fileReader.readLines(file).forEach(line -> {
                Optional<Worker> workerOpt = lineParser.parse(line);
                workerOpt.ifPresentOrElse(
                        this::addToDepartmentsData,
                        () -> InvalidData.invalidWorker.add(line));

            });
        });
    }

    private void addToDepartmentsData(Worker worker) {
        if (worker instanceof Manager) {
            Manager manager = (Manager) worker;
            DepartmentsData.managerByDepartmentName.put(
                    manager.getDepartmentName(),
                    manager
            );
        } else if (worker instanceof Employee) {
            Employee employee = (Employee) worker;
            DepartmentsData.employeesByManagerId
                    .computeIfAbsent(employee.getManagerId(), k -> new ArrayList<>())
                    .add(employee);
        }
    }
}
