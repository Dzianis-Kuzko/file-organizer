package com.korona.file_organizer.parser.line;

import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;


@AllArgsConstructor
public class LineParser {
    private static final String SEPARATOR = ",";
    private static final int EXPECTED_PARTS = 5;

    private final Map<String, WorkerLineHandler> handlers;

    /**
     * Parses a line into a Worker object if the format is valid and a handler exists.
     */

    public Optional<Worker> parse(String line) {
        if (line == null || line.isBlank()) {
            return Optional.empty();
        }

        String[] parts = Arrays.stream(line.split(SEPARATOR))
                .map(String::trim)
                .toArray(String[]::new);

        if (parts.length != EXPECTED_PARTS) {
            return Optional.empty();
        }

        WorkerLineHandler handler = handlers.get(parts[0]);
        if (handler == null) {
            return Optional.empty();
        }

        try {
            return Optional.of(handler.handle(parts));
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
    }
}