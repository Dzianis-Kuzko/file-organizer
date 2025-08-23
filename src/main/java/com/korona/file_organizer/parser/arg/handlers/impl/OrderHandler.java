package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.impl.SortOrder;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.parser.arg.ArgParserUtil;

import java.util.Optional;

public class OrderHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Parameter " + key + " requires a value");
        }

        Optional<SortOrder> sortOrder = ArgParserUtil.tryParseValue(value, SortOrder.class);

        if (sortOrder.isEmpty()) {
            throw new IllegalArgumentException("Error. Unsupported sort order: " + value);
        }

        config.setOrder(sortOrder.get());
    }
}
