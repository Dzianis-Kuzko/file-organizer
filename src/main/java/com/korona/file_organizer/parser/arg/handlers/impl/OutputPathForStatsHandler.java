package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.config.enums.OutputPathForStatsFlag;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class OutputPathForStatsHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Параметр " + key + " требует значение");
        }

        config.getOutputPath().setValue(Path.of(value));
        config.getOutputPath().setPosition(index);
    }

}
