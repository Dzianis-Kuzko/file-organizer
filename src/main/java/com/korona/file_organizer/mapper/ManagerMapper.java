package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Manager;
import com.korona.file_organizer.model.WorkerPosition;

import java.math.BigDecimal;

public final class ManagerMapper {
    private static final String TEMPLATE = "%s,%d,%s,%s";

    private ManagerMapper() {
        throw new UnsupportedOperationException("Utility class, should not be instantiated");
    }

    public static String mapToString(Manager manager) {
        return String.format(TEMPLATE,
                WorkerPosition.MANAGER.getPosition(),
                manager.getId(),
                manager.getName(),
                manager.getSalary()
        );
    }

    public static Manager mapToManager(String[] parts) {
        int id = Integer.parseInt(parts[1]);
        String name = parts[2];
        BigDecimal salary = new BigDecimal(parts[3]);
        String department = parts[4];
        return new Manager(id, name, salary, department);
    }
}
