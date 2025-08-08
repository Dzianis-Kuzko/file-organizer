package com.korona.file_organizer.parser.handlers;

import com.korona.file_organizer.model.Config;

public interface ArgHandler {
    boolean support(String arg);

    void handle(String[] args, int index, Config config);
}
