package com.korona.file_organizer.parser.arg.handlers;

import com.korona.file_organizer.model.Config;
import com.korona.file_organizer.model.enums.StatFlag;

import java.util.Arrays;

public class StatHandler implements ArgHandler {
    @Override
    public boolean support(String arg) {
        return Arrays.stream(StatFlag.values())
                .anyMatch(flag -> flag.getValue().equals(arg));
    }

    @Override
    public void handle(String[] args, int index, Config config) {
        config.setStatEnabled(true);
    }
}
