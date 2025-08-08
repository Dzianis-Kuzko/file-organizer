package com.korona.file_organizer.parser.handlers;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.enums.OrderFlag;
import com.korona.file_organizer.model.enums.SortOrder;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Optional;

public class OrderHandler implements ArgHandler {

    @Override
    public boolean support(String arg) {
        return ArgParserUtil.isValidParamWithValue(arg, OrderFlag.class);
    }

    @Override
    public void handle(String[] args, int index, Config config) {
        String value = ArgParserUtil.extractValue(args[index]);

        Optional<SortOrder> sortOrder = ArgParserUtil.tryParseValue(value, SortOrder.class);

        if (sortOrder.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый порядок сортировки: " + value);
        }

        config.setOrder(sortOrder.get());
    }
}
