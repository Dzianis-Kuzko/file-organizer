package com.korona.file_organizer.parser.line;

import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;

import java.util.List;
import java.util.Optional;

public class LineParser {
    private final static String SEPARATOR = ",";
    private final static int EXPECTED_PARTS = 5;

    private final List<WorkerLineHandler> handlers;

    public LineParser(List<WorkerLineHandler> handlers) {
        this.handlers = handlers;
    }

    public Optional<Worker> parse(String line) {
        Optional<Worker> workerResult = Optional.empty();

        if (line == null || line.trim().isEmpty()) {
            return workerResult;
        }

        String[] parts = line.split(SEPARATOR);
        if (parts.length != EXPECTED_PARTS) {
            return workerResult;
        }

        String type = parts[0].trim();
        for (WorkerLineHandler handler : handlers) {
            if (handler.supports(type)) {
                try {
                    workerResult = Optional.of(handler.handle(parts));
                    return workerResult;
                } catch (Exception e) {
                    return Optional.empty();
                }
            }
        }

        return workerResult;
    }
}