package com.korona.file_organizer.parser.line.handlers.impl;

import com.korona.file_organizer.mapper.EmployeeMapper;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;

public class EmployeeLineHandler implements WorkerLineHandler {
    @Override
    public Worker handle(String[] parts) {
        return EmployeeMapper.mapToEmployee(parts);
    }
}
