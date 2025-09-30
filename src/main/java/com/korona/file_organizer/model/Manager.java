package com.korona.file_organizer.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Manager extends Worker {
    private String departmentName;

    public Manager(int id, String name, BigDecimal salary, String departmentName) {
        super(id, name, salary);
        this.departmentName = departmentName;
    }

}
