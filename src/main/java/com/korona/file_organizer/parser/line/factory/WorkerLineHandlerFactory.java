package com.korona.file_organizer.parser.line.factory;

import com.korona.file_organizer.parser.line.handlers.EmployeeLineHandler;
import com.korona.file_organizer.parser.line.handlers.ManagerLineHandler;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;

import java.util.List;

public class WorkerLineHandlerFactory {
    public List<WorkerLineHandler> createWorkerLineHandlers() {
        return List.of(
                new EmployeeLineHandler(),
                new ManagerLineHandler()
        );
    }
}
