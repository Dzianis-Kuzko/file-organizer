package com.korona.file_organizer.model.enums;

public enum StatFlag implements Valued {
    LONG("--stat");

    private final String flag;

    StatFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
