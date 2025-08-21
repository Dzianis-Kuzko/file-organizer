package com.korona.file_organizer.config.enums.impl;

public enum OutputPathForStatsFlag implements Valued {
    LONG("--path");

    private final String flag;

    OutputPathForStatsFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
