package com.korona.file_organizer.model.enums;

public enum OutputPathFlag implements Valued {
    LONG("--path");

    private final String flag;

    OutputPathFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
