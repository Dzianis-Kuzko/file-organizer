package com.korona.file_organizer.config.enums.impl;

public enum OutputTypeForStatsFlag implements Valued {
    LONG("--output"),
    SHORT("-o");

    private final String flag;

    OutputTypeForStatsFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
