package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.SortField;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Optional;

public class SortHandler implements ArgHandler {


    @Override
    public void handle(String key, String value, Config config, int index) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Параметр " + key + " требует значение");
        }

        Optional<SortField> sortField = ArgParserUtil.tryParseValue(value, SortField.class);

        if (sortField.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый тип сортировки сотрудников: " + value);
        }

        config.setSortBy(sortField.get());
    }

}
