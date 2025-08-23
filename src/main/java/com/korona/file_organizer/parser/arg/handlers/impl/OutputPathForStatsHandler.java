package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;

import java.nio.file.Path;

public class OutputPathForStatsHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Error. Parameter " + key + " requires a value");
        }
        config.getOutputPathForStats().setValue(Path.of(value));
        config.getOutputPathForStats().setPosition(index);
    }
}
