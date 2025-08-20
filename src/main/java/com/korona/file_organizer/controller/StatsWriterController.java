package com.korona.file_organizer.controller;

import com.korona.file_organizer.writer.OutputWriter;
import com.korona.file_organizer.writer.impl.ConsoleWriter;
import com.korona.file_organizer.writer.impl.FileWriter;
import com.korona.file_organizer.mapper.DepartmentSalaryStatsMapper;
import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.model.DepartmentSalaryStats;
import com.korona.file_organizer.config.enums.OutputTypeForStats;
import com.korona.file_organizer.service.DepartmentService;
import com.korona.file_organizer.service.DepartmentStatsService;
import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class StatsWriterController {
    public static final String HEADER_FOR_STATS = "department, min, max, mid";

    private final DepartmentService departmentService;
    private final DepartmentStatsService departmentStatsService;
    private final Config config;

    public void writeStatistics() {

        try (OutputWriter writer = createWriter()) {
            writer.writeLine(HEADER_FOR_STATS);

            departmentService.getAllDepartments()
                    .stream()
                    .map(departmentStatsService::calculate)
                    .sorted(Comparator.comparing(DepartmentSalaryStats::getDepartmentName))
                    .map(DepartmentSalaryStatsMapper::mapToString)
                    .forEach(writer::writeLine);
        }
    }

    private OutputWriter createWriter() {
        if (config.getOutputType().getValue() == OutputTypeForStats.FILE) {
            return new FileWriter(config.getOutputPath().getValue());
        } else {
            return new ConsoleWriter();
        }
    }
}
