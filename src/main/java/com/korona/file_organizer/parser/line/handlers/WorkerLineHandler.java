package com.korona.file_organizer.parser.line.handlers;

import com.korona.file_organizer.model.Worker;

/**
 * Defines a contract for handling a parsed line representing a {@link Worker}.
 */
public interface WorkerLineHandler {

    /**
     * Converts the given string array into a {@link Worker}.
     *
     * @param parts the parsed line split into parts; never {@code null}
     * @return a {@link Worker} instance created from the provided data
     * @throws IllegalArgumentException if the input data is invalid or cannot be converted
     */
    Worker handle(String[] parts);
}
