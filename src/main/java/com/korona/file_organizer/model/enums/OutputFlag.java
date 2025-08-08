package com.korona.file_organizer.model.enums;

public enum OutputFlag implements Valued {
    LONG("--output"),
    SHORT("-o");

    private final String flag;

    OutputFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
