package com.korona.file_organizer.parser.line.handlers;

import com.korona.file_organizer.model.Worker;

public interface WorkerLineHandler {
    boolean supports(String type);
    Worker handle(String[] parts);
}
