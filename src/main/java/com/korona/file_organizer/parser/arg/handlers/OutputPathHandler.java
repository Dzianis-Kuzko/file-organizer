package com.korona.file_organizer.parser.arg.handlers;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.enums.OutputPathFlag;
import com.korona.file_organizer.util.ArgParserUtil;

import java.nio.file.Path;

public class OutputPathHandler implements ArgHandler {

    @Override
    public boolean support(String arg) {
        return ArgParserUtil.isValidParamWithValue(arg, OutputPathFlag.class);
    }

    @Override
    public void handle(String[] args, int index, Config config) {
        Path path = Path.of(ArgParserUtil.extractValue(args[index]));
        config.getOutputPath().setValue(path);
        config.getOutputPath().setPosition(index);
    }
}
