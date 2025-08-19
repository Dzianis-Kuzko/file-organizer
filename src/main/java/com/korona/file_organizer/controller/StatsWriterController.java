package com.korona.file_organizer.controller;

import com.korona.file_organizer.file.writer.OutputWriter;
import com.korona.file_organizer.file.writer.impl.ConsoleWriter;
import com.korona.file_organizer.file.writer.impl.FileWriter;
import com.korona.file_organizer.mapper.DepartmentSalaryStatsMapper;
import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.DepartmentSalaryStats;
import com.korona.file_organizer.model.enums.OutputType;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.DepartmentStatsService;
import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class StatsWriterController {
    private final DepartmentService departmentService;
    private final DepartmentStatsService departmentStatsService;
    private final Config config;

    public void writeStatistics() {

        try (OutputWriter writer = createWriter()) {
            writer.writeLine("department, min, max, mid");

            departmentService.getAllDepartments()
                    .stream()
                    .map(departmentStatsService::calculate)
                    .sorted(Comparator.comparing(DepartmentSalaryStats::getDepartmentName))
                    .map(DepartmentSalaryStatsMapper::mapToString)
                    .forEach(writer::writeLine);
        }
    }


    private OutputWriter createWriter() {
        if (config.getOutputType().getValue() == OutputType.FILE) {
            return new FileWriter(config.getOutputPath().getValue());
        } else {
            return new ConsoleWriter();
        }
    }
}
