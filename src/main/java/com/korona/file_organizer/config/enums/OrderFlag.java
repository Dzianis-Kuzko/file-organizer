package com.korona.file_organizer.config.enums;


public enum OrderFlag implements Valued {
    LONG("--order");

    private final String flag;

    OrderFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String getValue() {
        return this.flag;
    }
}
