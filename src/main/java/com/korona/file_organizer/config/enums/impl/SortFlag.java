package com.korona.file_organizer.config.enums.impl;

public enum SortFlag implements Valued {
    LONG("--sort"),
    SHORT("-s");

    private final String flag;

    SortFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
