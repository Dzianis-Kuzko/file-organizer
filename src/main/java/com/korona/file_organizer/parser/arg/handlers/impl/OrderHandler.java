package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.OrderFlag;
import com.korona.file_organizer.config.enums.SortFlag;
import com.korona.file_organizer.config.enums.SortOrder;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OrderHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Параметр " + key + " требует значение");
        }

        Optional<SortOrder> sortOrder = ArgParserUtil.tryParseValue(value, SortOrder.class);

        if (sortOrder.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый порядок сортировки: " + value);
        }

        config.setOrder(sortOrder.get());
    }

}
