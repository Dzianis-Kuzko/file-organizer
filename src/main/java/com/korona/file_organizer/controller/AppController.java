package com.korona.file_organizer.controller;

import com.korona.file_organizer.config.Config;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppController {
    private final DataLoadingController dataLoadingController;
    private final DepartmentWriterController departmentWriterController;
    private final InvalidDataWriterController invalidDataWriterController;
    private final StatsWriterController statsWriterController;
    private final Config config;


    public void process() {
        dataLoadingController.loadData();

        departmentWriterController.writeDepartments();

        invalidDataWriterController.writeInvalidData();

        if (config.isStatEnabled()) {
            statsWriterController.writeStatistics();
        }
    }
}
