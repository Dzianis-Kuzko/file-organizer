package com.korona.file_organizer.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Manager extends Worker {
    private String department;

    public Manager(int id, String name, BigDecimal salary, String department) {
        super(id, name, salary);
        this.department = department;
    }
}
