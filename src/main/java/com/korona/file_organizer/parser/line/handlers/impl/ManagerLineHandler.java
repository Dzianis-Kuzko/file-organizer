package com.korona.file_organizer.parser.line.handlers.impl;

import com.korona.file_organizer.mapper.ManagerMapper;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;

public class ManagerLineHandler implements WorkerLineHandler {
    @Override
    public Worker handle(String[] parts) {
        return ManagerMapper.mapToManager(parts);
    }
}
