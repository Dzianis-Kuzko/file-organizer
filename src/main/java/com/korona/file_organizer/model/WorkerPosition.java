package com.korona.file_organizer.model;

public enum WorkerPosition {
    EMPLOYEE("Employee"),
    MANAGER("Manager");

    private String position;

    WorkerPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }
}

