package com.korona.file_organizer.parser.line.factory;

import com.korona.file_organizer.model.WorkerPosition;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;
import com.korona.file_organizer.parser.line.handlers.impl.EmployeeLineHandler;
import com.korona.file_organizer.parser.line.handlers.impl.ManagerLineHandler;

import java.util.Map;

public final class WorkerLineHandlerFactory {
    private WorkerLineHandlerFactory() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static Map<String, WorkerLineHandler> createWorkerLineHandlers() {
        return Map.of(
                WorkerPosition.EMPLOYEE.getPosition(), new EmployeeLineHandler(),
                WorkerPosition.MANAGER.getPosition(), new ManagerLineHandler()
        );
    }
}
