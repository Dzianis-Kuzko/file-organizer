package com.korona.file_organizer.controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AppController {
    private final FileDataLoadingController fileDataLoadingController;
    private final FileDepartmentWriterController departmentWriterController;
    private final FileInvalidDataWriterController invalidDataWriterController;


    public void process(String[] args) {
        fileDataLoadingController.loadData();

        departmentWriterController.writeDepartment();

        invalidDataWriterController.writeInvalidData();
    }
}
