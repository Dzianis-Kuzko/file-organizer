package com.korona.file_organizer.parser.line.handlers.impl;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Worker;
import com.korona.file_organizer.parser.line.handlers.WorkerLineHandler;

import java.math.BigDecimal;

public class EmployeeLineHandler implements WorkerLineHandler {
    @Override
    public boolean supports(String type) {
        return "Employee".equals(type);
    }

    @Override
    public Worker handle(String[] parts) {
        int id = Integer.parseInt(parts[1].trim());
        String name = parts[2].trim();
        BigDecimal salary = new BigDecimal(parts[3].trim());
        int managerId = Integer.parseInt(parts[4].trim());
        return new Employee(id, name, salary, managerId);
    }
}
