package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.enums.SortField;
import com.korona.file_organizer.model.enums.SortFlag;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Optional;

public class SortHandler implements ArgHandler {

    @Override
    public boolean support(String arg) {
        return ArgParserUtil.isValidParamWithValue(arg, SortFlag.class);
    }

    @Override
    public void handle(String[] args, int index, Config config) {

        String value = ArgParserUtil.extractValue(args[index]);

        Optional<SortField> sortField = ArgParserUtil.tryParseValue(value, SortField.class);

        if (sortField.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый тип сортировки сотрудников: " + value);
        }

        config.setSortBy(sortField.get());
    }
}
