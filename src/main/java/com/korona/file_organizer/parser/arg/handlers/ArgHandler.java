package com.korona.file_organizer.parser.arg.handlers;

import com.korona.file_organizer.config.Config;

public interface ArgHandler {

    void handle(String key, String value, Config config, int index);

}
