package com.korona.file_organizer.model.enums;

public enum OutputType implements Valued {
    FILE("file"),
    CONSOLE("console");

    private final String type;

    OutputType(String type) {
        this.type = type;
    }

    @Override
    public String getValue() {
        return this.type;
    }
}
