package com.korona.file_organizer.controller;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.service.WorkerService;

public class Controller {
    private final WorkerService workerService;

    public Controller(WorkerService workerService) {
        this.workerService = workerService;
    }

    public void run(Config config) {


    }
}
