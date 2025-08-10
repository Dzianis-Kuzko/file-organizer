package com.korona.file_organizer.parser.arg.handlers;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.enums.OutputFlag;
import com.korona.file_organizer.model.enums.OutputType;
import com.korona.file_organizer.util.ArgParserUtil;

import java.util.Optional;

public class OutputTypeHandler implements ArgHandler {

    @Override
    public boolean support(String arg) {
        return ArgParserUtil.isValidParamWithValue(arg, OutputFlag.class);
    }

    @Override
    public void handle(String[] args, int index, Config config) {

        String value = ArgParserUtil.extractValue(args[index]);

        Optional<OutputType> outputType = ArgParserUtil.tryParseValue(value, OutputType.class);

        if (outputType.isEmpty()) {
            throw new IllegalArgumentException("Недопустимый способ вывода статистики: " + value);
        }

        config.setOutputTypeDefaulted(false);
        config.getOutputType().setValue(outputType.get());
        config.getOutputPath().setPosition(index);
    }
}
