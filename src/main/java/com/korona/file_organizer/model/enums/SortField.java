package com.korona.file_organizer.model.enums;


public enum SortField implements Valued {
    NAME("name"),
    SALARY("salary");

    private final String field;

    SortField(String field) {
        this.field = field;
    }

    @Override
    public String getValue() {
        return this.field;
    }
}
