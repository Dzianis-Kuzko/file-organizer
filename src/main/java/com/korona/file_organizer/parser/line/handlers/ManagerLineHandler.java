package com.korona.file_organizer.parser.line.handlers;

import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;

import java.math.BigDecimal;

public class ManagerLineHandler implements WorkerLineHandler{
    @Override
    public boolean supports(String type) {
        return "Manager".equals(type);
    }

    @Override
    public Worker handle(String[] parts) {
        int id = Integer.parseInt(parts[1].trim());
        String name = parts[2].trim();
        BigDecimal salary = new BigDecimal(parts[3].trim());
        String department = parts[4].trim();
        return new Manager(id, name, salary, department);
    }
}
