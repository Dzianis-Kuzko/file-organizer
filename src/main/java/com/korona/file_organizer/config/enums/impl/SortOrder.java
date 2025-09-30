package com.korona.file_organizer.config.enums.impl;


public enum SortOrder implements Valued {
    ASC("asc"),
    DESC("desc");

    private final String order;

    SortOrder(String order) {
        this.order = order;
    }

    @Override
    public String getValue() {
        return this.order;
    }
}
