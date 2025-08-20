package com.korona.file_organizer.config.enums;

public enum OutputTypeForStats implements Valued {
    FILE("file"),
    CONSOLE("console");

    private final String type;

    OutputTypeForStats(String type) {
        this.type = type;
    }

    @Override
    public String getValue() {
        return this.type;
    }
}
