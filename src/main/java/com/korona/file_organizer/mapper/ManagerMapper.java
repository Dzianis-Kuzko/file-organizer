package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Manager;

public final class ManagerMapper {
    private static final String TEMPLATE = "Manager,%d,%s,%s";

    private ManagerMapper() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String mapToString(Manager manager) {
        return String.format(TEMPLATE,
                manager.getId(),
                manager.getName(),
                manager.getSalary()
        );
    }
}
