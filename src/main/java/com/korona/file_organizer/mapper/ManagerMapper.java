package com.korona.file_organizer.mapper;

import com.korona.file_organizer.model.Manager;

public class ManagerMapper {
    public static String mapToString(Manager manager) {
        return String.format("Manager,%d,%s,%s",
                manager.getId(),
                manager.getName(),
                manager.getSalary()
        );
    }
}
