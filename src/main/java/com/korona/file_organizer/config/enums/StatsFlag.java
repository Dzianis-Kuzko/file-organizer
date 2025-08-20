package com.korona.file_organizer.config.enums;

public enum StatsFlag implements Valued {
    LONG("--stat");

    private final String flag;

    StatsFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
