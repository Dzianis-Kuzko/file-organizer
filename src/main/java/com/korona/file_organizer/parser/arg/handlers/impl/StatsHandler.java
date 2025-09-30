package com.korona.file_organizer.parser.arg.handlers.impl;

import com.korona.file_organizer.config.Config;
import com.korona.file_organizer.parser.arg.handlers.ArgHandler;

public class StatsHandler implements ArgHandler {

    @Override
    public void handle(String key, String value, Config config, int index) {
        config.setStatEnabled(true);
    }
}
