package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.OutputTypeForStats;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Optional;

public class OutputTypeForStatsHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {

        Optional<OutputTypeForStats> outputType = ArgParserUtil.tryParseValue(value, OutputTypeForStats.class);

        if (outputType.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый способ вывода статистики: " + value);
        }

        config.setOutputTypeDefaulted(false);
        config.getOutputType().setValue(outputType.get());
        config.getOutputPath().setPosition(index);
    }

}
