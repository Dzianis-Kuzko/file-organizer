package com.korona.file_organizer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public abstract class Worker {
    private int id;
    private String name;
    private BigDecimal salary;

}


