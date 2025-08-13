package com.korona.file_organizer.model;

import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter

public class Employee extends Worker {
    private int managerId;

    public Employee(int id, String name, BigDecimal salary, int managerId) {
        super(id, name, salary);
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString()+
                "managerId=" + managerId +
                '}';
    }
}
