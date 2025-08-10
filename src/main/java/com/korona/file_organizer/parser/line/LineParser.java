package com.korona.file_organizer.parser.line;

import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.Worker;

import java.math.BigDecimal;
import java.util.Optional;

public class LineParser {
    private static final String SEPARATOR = ",";
    private static final int EXPECTED_PARTS = 5;

    public Optional<Worker> tryParseLine(String line) {

        if (line == null || line.trim().isEmpty()) {
            return Optional.empty();
        }

        String[] parts = line.split(SEPARATOR, -1);
        if (parts.length != EXPECTED_PARTS) {
            return Optional.empty();
        }

        try {
            String workerType = parts[0].trim();
            int id = Integer.parseInt(parts[1].trim());
            String name = parts[2].trim();
            String salaryStr = parts[3].trim();
            String referenceStr = parts[4].trim();

            BigDecimal salary = salaryStr.isEmpty() ? null : new BigDecimal(salaryStr);

            if ("Manager".equalsIgnoreCase(workerType)) {
                String departmentName = referenceStr;
                return Optional.of(new Manager(id, name, salary, departmentName));
            } else if ("Employee".equalsIgnoreCase(workerType)) {
                int managerId = Integer.parseInt(referenceStr);
                return Optional.of(new Employee(id, name, salary, managerId));
            }
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
        return null;
    }
}