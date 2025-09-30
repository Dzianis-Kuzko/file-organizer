package com.korona.file_organizer.service;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.impl.SortOrder;
import com.korona.file_organizer.model.Employee;

import java.util.Comparator;
import java.util.Optional;

public class ComparatorFactory {
    public static Optional<Comparator<Employee>> getComparator(Config config) {
        if (config.getSortBy() == null) {
            return Optional.empty();
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

        return Optional.of(comparator);
    }
}
