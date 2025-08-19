package com.korona.file_organizer.controller;

import com.korona.file_organizer.model.Config;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppController {
    private final FileDataLoadingController fileDataLoadingController;
    private final FileDepartmentWriterController departmentWriterController;
    private final FileInvalidDataWriterController invalidDataWriterController;
    private final StatsWriterController  statsWriterController;
    private final Config config;


    public void process(String[] args) {
        fileDataLoadingController.loadData();

        departmentWriterController.writeDepartment();

        invalidDataWriterController.writeInvalidData();

        if(config.isStatEnabled()){
            statsWriterController.writeStatistics();
        }
    }
}
