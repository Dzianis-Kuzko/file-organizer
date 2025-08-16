package com.korona.file_organizer.service.impl;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.Employee;
import com.korona.file_organizer.model.enums.SortOrder;

import java.util.Comparator;

public class ComparatorFactory {
    public static Comparator<Employee> getComparator(Config config) {
        if (config.getSortBy() == null) {
            return null;
        }

        Comparator<Employee> comparator;
        switch (config.getSortBy()) {
            case NAME -> comparator = Comparator.comparing(Employee::getName);
            case SALARY -> comparator = Comparator.comparing(Employee::getSalary);
            default -> throw new IllegalArgumentException("Unknown sort field: " + config.getSortBy());
        }

        if (config.getOrder() == SortOrder.DESC) {
            comparator = comparator.reversed();
        }

        return comparator;
    }
}
